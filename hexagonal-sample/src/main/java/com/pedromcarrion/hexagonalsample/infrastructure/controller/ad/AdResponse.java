package com.pedromcarrion.hexagonalsample.infrastructure.controller.ad;

public class AdResponse {

    private final String id;
    private final String title;

    public AdResponse(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
