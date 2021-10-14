package com.pedromcarrion.hexagonalsample.infrastructure.configuration;

import com.pedromcarrion.hexagonalsample.domain.ad.AdRepository;
import com.pedromcarrion.hexagonalsample.infrastructure.controller.ad.AdResponseMapper;
import com.pedromcarrion.hexagonalsample.infrastructure.repository.ad.PostgreAdRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class InfrastructureConfiguration {

    @Bean
    public AdRepository adRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        return new PostgreAdRepository(namedParameterJdbcTemplate);
    }

    @Bean
    public AdResponseMapper adResponseMapper(){
        return new AdResponseMapper();
    }
}
