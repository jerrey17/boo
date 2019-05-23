package com.rui.boo.config;


import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.reactive.config.PathMatchConfigurer;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * @Author rui
 * @Date 2019-01-16 14:26
 **/
@SpringBootConfiguration
public class WebConfig implements WebFluxConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

//    @Override
//    public void configurePathMatching(PathMatchConfigurer configurer) {
//        configurer.addPathPrefix("/boo", HandlerTypePredicate.builder().basePackage("com.rui.boo").build());
//    }

}
