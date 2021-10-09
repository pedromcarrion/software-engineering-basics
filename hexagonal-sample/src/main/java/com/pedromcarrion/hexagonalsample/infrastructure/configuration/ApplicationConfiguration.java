package com.pedromcarrion.hexagonalsample.infrastructure.configuration;

import com.pedromcarrion.hexagonalsample.application.ad.AdDtoMapper;
import com.pedromcarrion.hexagonalsample.application.ad.ChangeAdStatusUseCase;
import com.pedromcarrion.hexagonalsample.application.ad.GetAdUseCase;
import com.pedromcarrion.hexagonalsample.domain.ad.AdRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public GetAdUseCase getAdUseCase(AdRepository adRepository, AdDtoMapper adDtoMapper){
        return new GetAdUseCase(adRepository, adDtoMapper);
    }

    @Bean
    public AdDtoMapper adDtoMapper(){
        return new AdDtoMapper();
    }

    @Bean
    public ChangeAdStatusUseCase changeAdStatusUseCase(){
        return new ChangeAdStatusUseCase();
    }
}
