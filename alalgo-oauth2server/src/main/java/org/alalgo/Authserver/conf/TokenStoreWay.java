package org.alalgo.Authserver.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.util.Assert;

@Configuration
public class TokenStoreWay {
	/**
	 * jdbc token 配置
	 */	
	@Autowired
	private DataSource dataSource;
	@Bean
	public TokenStore jdbcTokenStore() {
	    Assert.state(dataSource != null, "DataSource must be provided");
	    return new JdbcTokenStore(dataSource);
	}	
	
	/**
	* jwt Token 配置
	* 有对称密钥、非对称密钥两种方式，这里采用了对称密钥的方式
	*
	*/	
	   //@Value("${default.jwt.signing.key}")
	   //private String defaultJwtSigningKey;
	  @Bean
	  @Primary
	   public TokenStore jwtTokenStore() {
	       return new JwtTokenStore(jwtAccessTokenConverter());
	   }

	   @Bean
	   public JwtAccessTokenConverter jwtAccessTokenConverter() {
	       JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
	       jwtAccessTokenConverter.setSigningKey("123");
	       return jwtAccessTokenConverter;
	   }
	   
	   /*
	    * redis token 配置
	    */
	   @Autowired
	   private RedisConnectionFactory redisConnectionFactory;
	   @Bean
	   public TokenStore redisTokenStore() {
	       return new RedisTokenStore(redisConnectionFactory);
	   }
	
}
