package com.pedromcarrion.hexagonalsample.infrastructure.configuration;

import com.pedromcarrion.hexagonalsample.domain.ad.AdRepository;
import com.pedromcarrion.hexagonalsample.infrastructure.controller.ad.AdResponseMapper;
import com.pedromcarrion.hexagonalsample.infrastructure.repository.ad.InMemoryAdRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfrastructureConfiguration {

    @Bean
    public AdRepository adRepository(){
        return new InMemoryAdRepository();
    }

    @Bean
    public AdResponseMapper adResponseMapper(){
        return new AdResponseMapper();
    }
}
