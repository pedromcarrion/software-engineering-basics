package com.pedromcarrion.hexagonalsample.infrastructure.repository.ad;

import com.pedromcarrion.hexagonalsample.domain.ad.Ad;
import com.pedromcarrion.hexagonalsample.domain.ad.AdId;
import com.pedromcarrion.hexagonalsample.domain.ad.AdRepository;

import java.util.ArrayList;
import java.util.Optional;

public class InMemoryAdRepository implements AdRepository {

    private final ArrayList<Ad> ads;

    public InMemoryAdRepository() {
        ads = new ArrayList<>();
    }

    @Override
    public Optional<Ad> find(AdId adId) {

        return ads.stream().filter(ad -> ad.getId() == adId).findFirst();
    }
}
