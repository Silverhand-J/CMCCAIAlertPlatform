package com.tencent.wxcloudrun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WeChatConfigurer implements WebMvcConfigurer {

    //图片存储路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/alert/**").addResourceLocations("file:C:\\Users\\sheny\\Documents\\SpringBootProject\\AlertPlatform\\src\\main\\resources\\images\\alert\\");
    }
}
