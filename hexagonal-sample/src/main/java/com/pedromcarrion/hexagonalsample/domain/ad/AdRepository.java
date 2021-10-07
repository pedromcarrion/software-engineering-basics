package com.pedromcarrion.hexagonalsample.domain.ad;

import java.util.Optional;

public interface AdRepository {
    Optional<Ad> find(AdId adId);
}
