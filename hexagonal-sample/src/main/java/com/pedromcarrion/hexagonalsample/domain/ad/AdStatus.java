package com.pedromcarrion.hexagonalsample.domain.ad;

public enum AdStatus {
    OK, NOOK;

    public static AdStatus from(String status) {
        return AdStatus.valueOf(status.toUpperCase());
    }
}
