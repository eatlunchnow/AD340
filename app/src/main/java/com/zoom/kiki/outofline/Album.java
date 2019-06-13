package com.zoom.kiki.outofline;

public class Album {

    private String AlbumArtist;
    private String AlbumTitle;
    private String AlbumReleaseYear;

    public Album() {
    }

    public Album(String albumArtist, String albumTitle, String albumReleaseYear) {
        AlbumArtist = albumArtist;
        AlbumTitle = albumTitle;
        AlbumReleaseYear = albumReleaseYear;
    }

    public String getAlbumArtist() {
        return AlbumArtist;
    }

    public void setAlbumArtist(String albumArtist) {
        AlbumArtist = albumArtist;
    }

    public String getAlbumTitle() {
        return AlbumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        AlbumTitle = albumTitle;
    }

    public String getAlbumReleaseYear() {
        return AlbumReleaseYear;
    }

    public void setAlbumReleaseYear(String albumReleaseYear) {
        AlbumReleaseYear = albumReleaseYear;
    }
}
