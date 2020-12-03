package org.alalgo.Authserver.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
    	//内存存储获取
       /*
    	clients.inMemory()
            .withClient("SampleClientId")
            .secret(new BCryptPasswordEncoder().encode("secret"))
            .authorizedGrantTypes("authorization_code")
            .scopes("user_info")
            .autoApprove(true)
            .redirectUris("http://localhost:8888/login/local")
            .accessTokenValiditySeconds(60); 
        */
        //数据库存储获取
        clients.jdbc(dataSource);
    }
    
    @Override
    public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()")
            .checkTokenAccess("isAuthenticated()").allowFormAuthenticationForClients();
    }
    
    
    //jwt token,token 放入jwt ，可以自证，resource server无需请求authorization server进行验证
    @Autowired
    private TokenStore jwtTokenStore;
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;
    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;    
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(jwtTokenStore)
			.accessTokenConverter(jwtAccessTokenConverter)
			.authenticationManager(authenticationManager);
	}
	@Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(jwtTokenStore);
        defaultTokenServices.setSupportRefreshToken(true);
        return defaultTokenServices;
    }
}
