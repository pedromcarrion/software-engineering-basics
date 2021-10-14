package com.pedromcarrion.hexagonalsample.unittests.application.ad;

import com.pedromcarrion.hexagonalsample.application.ad.AdDto;
import com.pedromcarrion.hexagonalsample.application.ad.AdDtoMapper;
import com.pedromcarrion.hexagonalsample.application.ad.GetAdQuery;
import com.pedromcarrion.hexagonalsample.application.ad.GetAdUseCase;
import com.pedromcarrion.hexagonalsample.domain.ad.Ad;
import com.pedromcarrion.hexagonalsample.domain.ad.AdId;
import com.pedromcarrion.hexagonalsample.domain.ad.AdRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class GetAdUseCaseShould {

    @Test
    void return_an_ad_with_correct_values() {

        AdDtoMapper adDtoMapper = new AdDtoMapper();
        AdRepository adRepository = mock(AdRepository.class);
        GetAdUseCase getAdUseCase = new GetAdUseCase(adRepository, adDtoMapper);

        String id = UUID.randomUUID().toString();
        String title = "tittle of an ad";
        AdId adId = new AdId(id);
        when(adRepository.find(adId)).thenReturn(Optional.of(new Ad(adId, title)));


        GetAdQuery getAdQuery = new GetAdQuery(id);

        AdDto adDto = getAdUseCase.execute(getAdQuery);

        assertThat(adDto.getId()).isEqualTo(id);
        assertThat(adDto.getTitle()).isEqualTo(title);
    }
}