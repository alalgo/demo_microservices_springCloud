package org.alalgo.bpm.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
/**
 * 
* @Description: 该拦截器的顺序在资源服务器拦截器之前
* @author security
* @date 2019年2月25日
*
*
 */
@Configuration
//@EnableWebSecurity
//@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    	/*
     * 主要配置路径，也就是资源的访问权限
    */
    @Override
    public void configure(HttpSecurity http) throws Exception {
    	http.httpBasic().disable();
        http.requestMatchers()
        .and()
        .authorizeRequests()
        .antMatchers("/**").permitAll()
        .anyRequest().authenticated()
        .and().formLogin().permitAll()
        .and().csrf().disable();
       
    }

	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
		web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
	}
	@Bean
	public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
	    StrictHttpFirewall firewall = new StrictHttpFirewall();
	    firewall.setAllowUrlEncodedSlash(true);
	    firewall.setAllowSemicolon(true);
	    return firewall;
	}    

}
