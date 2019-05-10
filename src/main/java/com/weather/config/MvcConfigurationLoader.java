package com.weather.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan
public class MvcConfigurationLoader implements WebMvcConfigurer {
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {
		InternalResourceViewResolver internalResolver = new InternalResourceViewResolver();
		internalResolver.setPrefix("/WEB-INF/view/");
		internalResolver.setSuffix(".jsp");
		internalResolver.setViewClass(JstlView.class);
		viewResolverRegistry.viewResolver(internalResolver);
	}
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry resourceHandlerRegistry) {
	    resourceHandlerRegistry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
}
