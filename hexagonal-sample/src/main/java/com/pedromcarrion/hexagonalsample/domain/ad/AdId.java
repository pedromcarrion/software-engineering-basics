package com.pedromcarrion.hexagonalsample.domain.ad;

import java.util.Objects;

public class AdId {
    private final String id;

    public AdId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdId adId = (AdId) o;
        return Objects.equals(id, adId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String asString() {
        return id;
    }
}
