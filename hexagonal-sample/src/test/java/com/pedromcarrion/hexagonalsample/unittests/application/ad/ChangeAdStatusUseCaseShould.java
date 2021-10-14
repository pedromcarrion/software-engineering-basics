package com.pedromcarrion.hexagonalsample.unittests.application.ad;


import com.pedromcarrion.hexagonalsample.application.ad.ChangeAdStatusCommand;
import com.pedromcarrion.hexagonalsample.application.ad.ChangeAdStatusUseCase;
import com.pedromcarrion.hexagonalsample.domain.ad.Ad;
import com.pedromcarrion.hexagonalsample.domain.ad.AdId;
import com.pedromcarrion.hexagonalsample.domain.ad.AdRepository;
import com.pedromcarrion.hexagonalsample.domain.ad.AdStatus;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ChangeAdStatusUseCaseShould {

    @Test
    public void should_change_ad_status_and_save(){

        String id = UUID.randomUUID().toString();
        AdId adId = new AdId(id);
        String status = "nook";
        AdRepository adRepository = mock(AdRepository.class);

        when(adRepository.find(adId)).thenReturn(Optional.of(new Ad(adId, "title")));

        ChangeAdStatusUseCase changeAdStatusUseCase = new ChangeAdStatusUseCase(adRepository);

        ChangeAdStatusCommand changeAdStatusCommand = new ChangeAdStatusCommand(id, status);
        changeAdStatusUseCase.execute(changeAdStatusCommand);

        ArgumentCaptor<Ad> adCaptor = ArgumentCaptor.forClass(Ad.class);
        verify(adRepository).save(adCaptor.capture());
        Ad ad = adCaptor.getValue();

        assertThat(ad.getStatus()).isEqualTo(AdStatus.NOOK);
    }
}