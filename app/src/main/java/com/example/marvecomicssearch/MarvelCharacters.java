package com.example.marvecomicssearch;
import java.util.ArrayList;
import java.util.List;


/**
 * Superheros information.
 */
public class MarvelCharacters {
    private List<Comics> comics;
    private int id;
    private String name;
    private String background;
    private String imageUrl;
    MarvelCharacters() {
        comics = new ArrayList<>();
        id = 0;
        name = "none";
        background = "none";
    }
    public int getId() {
        return id;
    }

    public List<Comics> getComics() {
        return comics;
    }

    public String getBackground() {
        return background;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void setComics(List<Comics> comics) {
        this.comics = comics;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl + "/standard_small.jpg";
    }
}
