package com.company;

public class ArtistController {
    String name;
    String country;
    public void create(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String findByName() {
        return name;
    }
}
