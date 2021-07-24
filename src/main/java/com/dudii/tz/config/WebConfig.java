package com.dudii.tz.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@PropertySource("classpath:/application.yaml")
public class WebConfig implements WebMvcConfigurer {

    @Value("${cross-origin-url}")
    String corsURL;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("https://dudii-medical-cards.herokuapp.com/")
                .allowedMethods("GET", "POST","PUT", "DELETE");
    }

}
