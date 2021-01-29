package org.alalgo.usc.conf;

import org.alalgo.usc.filter.LogCostFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置过滤器，也可在application类中通过@ServletComponentScan配置
 * @author security
 *
 */
@Configuration
public class FilterConf {
	   @Bean
	    public FilterRegistrationBean registFilter() {
	        FilterRegistrationBean registration = new FilterRegistrationBean();
	        registration.setFilter(new LogCostFilter());
	        registration.addUrlPatterns("/*");
	        registration.setName("LogCostFilter");
	        registration.setOrder(1);
	        return registration;
	    }
}
