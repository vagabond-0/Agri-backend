package com.example.Agri.Configuration;


import com.example.Agri.DB;
import com.example.Agri.DevData;
import com.example.Agri.ProductionData;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @ConditionalOnProperty(name = "project.mode",havingValue = "development")
    public DB getDevelopmentDB(){
        return new DevData();
    }

    @Bean
    @ConditionalOnProperty(name = "project.mode",havingValue = "production")
    public DB getProductionDB(){
        return new ProductionData();
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
