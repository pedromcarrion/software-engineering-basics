package com.pedromcarrion.hexagonalsample.application.ad;

import com.pedromcarrion.hexagonalsample.domain.ad.Ad;
import com.pedromcarrion.hexagonalsample.domain.ad.AdId;
import com.pedromcarrion.hexagonalsample.domain.ad.AdNotFoundException;
import com.pedromcarrion.hexagonalsample.domain.ad.AdRepository;

import java.util.Optional;

public class GetAdUseCase {

    private final AdRepository adRepository;
    private final AdDtoMapper adDtoMapper;

    public GetAdUseCase(AdRepository adRepository, AdDtoMapper adDtoMapper) {
        this.adRepository = adRepository;
        this.adDtoMapper = adDtoMapper;
    }

    public AdDto execute(GetAdQuery getAdQuery) {
        AdId adId = new AdId(getAdQuery.getId());
        Optional<Ad> ad = adRepository.find(adId);
        return adDtoMapper.map(ad.orElseThrow(() -> new AdNotFoundException(adId)));
    }
}
