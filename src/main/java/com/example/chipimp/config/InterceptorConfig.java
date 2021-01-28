package com.example.chipimp.config;


import com.example.chipimp.component.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 莫息涛
 * @Description: 登录相关的拦截器的配置类
 * @date 2020/3/11 16:35
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       // registry.addInterceptor(new LoginInterceptor())
         //       .excludePathPatterns("/toLogin","/checkUser","/toLogin/","/checkUser/");
    }
}
