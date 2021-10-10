package com.pedromcarrion.hexagonalsample.infrastructure.repository.ad;

import com.pedromcarrion.hexagonalsample.domain.ad.Ad;
import com.pedromcarrion.hexagonalsample.domain.ad.AdId;
import com.pedromcarrion.hexagonalsample.domain.ad.AdRepository;

import java.util.HashMap;
import java.util.Optional;

public class InMemoryAdRepository implements AdRepository {

    private final HashMap<AdId, Ad> ads;

    public InMemoryAdRepository() {
        ads = new HashMap<>();
    }

    @Override
    public Optional<Ad> find(AdId adId) {

        if (ads.containsKey(adId)) {
            return Optional.of(ads.get(adId));
        }
        return Optional.empty();
    }

    @Override
    public void save(Ad ad) {
        ads.put(ad.getId(), ad);
    }
}
