package com.group9.seckill.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//配置mvcConfig
public class MvcConfig implements WebMvcConfigurer {
//    @Override
//    重写添加拦截器方法，添加以下四个路由需要拦截器拦截
//    public void addInterceptors(InterceptorRegistry registry) {
////        registry.addInterceptor(new ApplyCardHandlerInterceptor()).addPathPatterns("/CardApply").
////                addPathPatterns("/TransferAccount").addPathPatterns("/savemoney").addPathPatterns("/cancellation");
////
////    }

    @Bean // 添加@Bean后原来的WebMvcConfigurer不在作用，而是使用我的@Bean，因为原来的@Bean有@ifonmissBean注解
//    配置路由与template模板映射
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
//                根目录对应template模板渲染index.html，以下同理
                registry.addViewController("/").setViewName("register");
                registry.addViewController("/login").setViewName("login");
                registry.addViewController("/register").setViewName("register");
                registry.addViewController("/").setViewName("redirect:/index.html");
            }
        };
        return configurer;
    }

}