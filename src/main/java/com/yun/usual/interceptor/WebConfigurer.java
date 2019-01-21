package com.yun.usual.interceptor;

import com.yun.usual.interceptor.handle.AdminInterceptor;
import com.yun.usual.interceptor.handle.ApiWebInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @author yrz
 */
@Configuration
public class WebConfigurer extends WebMvcConfigurationSupport {

    @Autowired
    private ApiWebInterceptor apiWebInterceptor;

    @Autowired
    private AdminInterceptor adminInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //前端接口拦截器
        String[] apiExecute = {
                "/api/login/**",
                "/api/posts/index",
                "/api/posts/info",
                "/api/reply/my_comments",
                "/api/reply/index"
        };

        registry.addInterceptor(apiWebInterceptor).addPathPatterns("/api/**").excludePathPatterns(apiExecute);
        //后台拦截器
        registry.addInterceptor(adminInterceptor).addPathPatterns("/admin","/admin/**","/admin/**/**").excludePathPatterns("/admin/login/**");
        super.addInterceptors(registry);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        // 注册Spring data jpa pageable的参数分解器
        argumentResolvers.add(new PageableHandlerMethodArgumentResolver());
    }

}
