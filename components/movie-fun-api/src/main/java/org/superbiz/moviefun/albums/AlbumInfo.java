package org.superbiz.moviefun.albums;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class AlbumInfo {

    public AlbumInfo() {
    }

    public AlbumInfo(String artist, String title, int year, int rating) {
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.rating = rating;
    }


    private Long id;

    private String artist;
    private String title;
    private int year;
    private int rating;

    public Long getId() {
        return id;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlbumInfo albumInfo = (AlbumInfo) o;

        if (getYear() != albumInfo.getYear()) return false;
        if (getRating() != albumInfo.getRating()) return false;
        if (getId() != null ? !getId().equals(albumInfo.getId()) : albumInfo.getId() != null) return false;
        if (getArtist() != null ? !getArtist().equals(albumInfo.getArtist()) : albumInfo.getArtist() != null)
            return false;
        return getTitle() != null ? getTitle().equals(albumInfo.getTitle()) : albumInfo.getTitle() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getArtist() != null ? getArtist().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + getYear();
        result = 31 * result + getRating();
        return result;
    }
}
