package org.alalgo.bpm.conf;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

public class Cfg_view extends WebMvcConfigurationSupport{
	 @Override
	protected void addViewControllers(ViewControllerRegistry registry) {
		 registry.addViewController("/").setViewName("/index.html");
	}
}
