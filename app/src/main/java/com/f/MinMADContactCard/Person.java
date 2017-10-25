package com.f.MinMADContactCard;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by ferdinand on 10-10-2017.
 */

public class Person implements Serializable{
    private String imageUrl;
    private String thumbnailUrl;
    private String hiresUrl;
    private String firstName;
    private String lastName;
    private String email;

    public Person(String imageUrl, String firstname, String lastName) {
        this.imageUrl = imageUrl;
        this.firstName = firstname;
        this.lastName = lastName;
    }

    public Person(String firstname, String lastName, String email, String thumbnailUrl, String imageUrl) {
        this.imageUrl = imageUrl;
        this.firstName = firstname;
        this.lastName = lastName;
        this.email = email;
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getHiresUrl() {
        return hiresUrl;
    }

    public void setHiresUrl(String hiresUrl) {
        this.hiresUrl = hiresUrl;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return firstName + " " + lastName;
    }
}

