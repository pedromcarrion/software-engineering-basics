package com.pedromcarrion.hexagonalsample.application.ad;

import com.pedromcarrion.hexagonalsample.domain.ad.Ad;

public class AdDtoMapper {
    public AdDto map(Ad ad) {
        return new AdDto(ad.getId().asString(), ad.getTitle());
    }
}
