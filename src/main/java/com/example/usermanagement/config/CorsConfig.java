
package com.example.usermanagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")

                // 允许访问的前端地址
                .allowedOrigins(
                        "http://127.0.0.1:5500",
                        "http://localhost:5500"
                )

                // 允许的 HTTP 请求方法
                .allowedMethods(
                        "GET",
                        "POST",
                        "PUT",
                        "DELETE",
                        "OPTIONS"
                )

                // 允许请求携带的请求头
                .allowedHeaders("*")

                // 当前项目不使用跨域 Cookie
                .allowCredentials(false)

                // 预检请求缓存时间（秒）
                .maxAge(3600);
    }
}
