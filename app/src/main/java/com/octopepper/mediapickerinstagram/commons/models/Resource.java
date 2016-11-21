package com.octopepper.mediapickerinstagram.commons.models;

/*
 * Created by Guillaume on 21/11/2016.
 */

public class Resource {

    private long id;
    private int type;

    public Resource() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}