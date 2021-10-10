package com.pedromcarrion.hexagonalsample.application.ad;

import com.pedromcarrion.hexagonalsample.domain.ad.*;

import java.util.Optional;

public class ChangeAdStatusUseCase {
    private final AdRepository adRepository;

    public ChangeAdStatusUseCase(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    public void execute(ChangeAdStatusCommand changeAdStatusCommand) {

        AdId  adId = new AdId(changeAdStatusCommand.getId());
        Optional<Ad> optionalAd = adRepository.find(adId);

        Ad ad = optionalAd.orElseThrow(() -> new AdNotFoundException(adId));

        AdStatus newAdStatus = AdStatus.from(changeAdStatusCommand.getStatus());
        ad.changeStatus(newAdStatus);

        adRepository.save(ad);
    }
}
