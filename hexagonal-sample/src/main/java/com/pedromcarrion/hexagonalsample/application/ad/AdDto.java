package com.pedromcarrion.hexagonalsample.application.ad;

public class AdDto {

    private final String id;
    private final String title;

    public AdDto(String id, String title) {
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
