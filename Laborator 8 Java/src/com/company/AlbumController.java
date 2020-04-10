package com.company;

public class AlbumController {
    String name;
    int artistId;
    int releaseYear;
    public void create(String name, int artistId, int releaseYear) {
        this.name = name;
        this.artistId = artistId;
        this.releaseYear=releaseYear;
    }
    public int findByArtist(int artistId){
        return this.artistId;
    }
}
