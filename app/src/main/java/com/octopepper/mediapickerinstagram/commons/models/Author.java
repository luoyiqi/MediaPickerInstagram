package com.octopepper.mediapickerinstagram.commons.models;

/*
 * Created by Guillaume on 21/11/2016.
 */

public class Author extends Resource {

    private String firstName;
    private String lastName;

    public Author() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
