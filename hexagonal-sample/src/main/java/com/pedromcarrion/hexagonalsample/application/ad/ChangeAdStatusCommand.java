package com.pedromcarrion.hexagonalsample.application.ad;

public class ChangeAdStatusCommand {
    private final String id;
    private final String status;

    public ChangeAdStatusCommand(String id, String status) {

        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
}
