package org.alalgo.gateway.conf.oauth2client;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
@Configuration
@EnableResourceServer
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {
	private static final String[] AUTH_WHITELIST = {
    		"/**/v2/api-docs",
    		"/v2/api-docs",
    		"/swagger-ui.html",
    		"/webjars/**",
    		"/doc.html",
    		"/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
    		"swagger-resources/configuration/ui"			
	};
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.httpBasic().disable();
        http.authorizeRequests().antMatchers("/oauthserver/**").permitAll();
        //容许访问swagger ui相关资源
        for (String au:AUTH_WHITELIST) {
               http.authorizeRequests().antMatchers(au).permitAll();
        }
        http.authorizeRequests().anyRequest().authenticated();
	}
}
