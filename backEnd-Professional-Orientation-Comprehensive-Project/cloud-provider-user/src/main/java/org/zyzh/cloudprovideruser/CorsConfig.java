package org.zyzh.cloudprovideruser;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer
{
    /**
     * 开启跨域
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路由
        registry.addMapping("/**")
                //允许远端访问的域名
                .allowedOrigins("*")
                //允许请求的方法("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowedMethods("*")
                //允许请求头
                .allowedHeaders("*");
    }
}
