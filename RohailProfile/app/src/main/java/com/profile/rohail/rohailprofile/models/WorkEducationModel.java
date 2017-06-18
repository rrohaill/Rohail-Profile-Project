package com.profile.rohail.rohailprofile.models;

import java.io.Serializable;

/**
 * Created by Rohail on 6/17/2017.
 */

public class WorkEducationModel implements Serializable {

    private String description;
    private String title;
    private String locationDate;
    private Integer icon;

    public WorkEducationModel() {
    }

    public String getLocationDate() {
        return locationDate;
    }

    public void setLocationDate(String locationDate) {
        this.locationDate = locationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "WorkEducationModel{" +
                "description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", locationDate='" + locationDate + '\'' +
                ", icon=" + icon +
                '}';
    }
}
