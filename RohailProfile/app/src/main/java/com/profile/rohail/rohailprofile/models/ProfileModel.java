package com.profile.rohail.rohailprofile.models;

import java.io.Serializable;

/**
 * Created by Rohail on 6/16/2017.
 */

public class ProfileModel implements Serializable {

    private String title;
    private int id;

    public ProfileModel(String title, int id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProfileModel{" +
                "title='" + title + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
