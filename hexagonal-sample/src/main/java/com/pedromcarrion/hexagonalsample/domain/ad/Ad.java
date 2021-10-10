package com.pedromcarrion.hexagonalsample.domain.ad;

public class Ad {

    private final AdId id;
    private final String title;
    private AdStatus status;

    public Ad(AdId id, String title) {
        this.id = id;
        this.title = title;
        this.status = AdStatus.OK;
    }

    public AdId getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public AdStatus getStatus() {
        return status;
    }

    public void changeStatus(AdStatus newAdStatus) {
        this.status = newAdStatus;
    }
}
