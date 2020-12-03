package org.alalgo.Authserver.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	@Autowired
	DataSource dataSource;
	/**
	 * 主要配置身份认证来源，也就是用户及其角色。
	 * 三种方式配置数据源：1、数据源放在内存中；2、数据源放入数据库中，自定义authenticationProvider；3、数据源放入数据库中，通过系统的jdbcAuthentication
	 */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
    	/*
        auth.inMemoryAuthentication()
            .withUser("john")
            .password(passwordEncoder().encode("123"))
            .roles("USER");
            */
    	
        //auth.authenticationProvider(myAuthenticationProvider);
    	
        auth.jdbcAuthentication()
	        .dataSource(dataSource)
	        .usersByUsernameQuery("select username, password, enable from user where username=?")
	        .authoritiesByUsernameQuery("select u.username,r.roleName from user u left join UserRole ur on u.userId = ur.userId left join role r on ur.roleid = r.roleid where u.username =?")
	        ;
    } 

    @Override
    @Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    	/*
     * 主要配置路径，也就是资源的访问权限
    */
    @Override
    public void configure(HttpSecurity http) throws Exception {
    	http.httpBasic().disable();
        http.requestMatchers()
        .and()
        .authorizeRequests()
        .antMatchers("/oauth/**","/login").permitAll()
        .anyRequest().authenticated()
        .and().formLogin().permitAll()
        .and().csrf().disable();
       
    }
     

}
