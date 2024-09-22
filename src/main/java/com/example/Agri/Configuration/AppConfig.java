package com.example.Agri.Configuration;

import com.example.Agri.DB;
import com.example.Agri.DevData;
import com.example.Agri.ProductionData;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig {

    // Conditional Bean for Development Database
    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "development")
    public DB getDevelopmentDB() {
        return new DevData();
    }

    // Conditional Bean for Production Database
    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "production")
    public DB getProductionDB() {
        return new ProductionData();
    }

    // ModelMapper Bean for object mapping
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    // CORS Configuration to allow all origins
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }
}
