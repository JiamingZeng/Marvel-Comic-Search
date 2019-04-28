package com.example.marvecomicssearch;
import java.util.ArrayList;
import java.util.List;


/**
 * Superheros information.
 */
public class MarvelCharacters {
    /**
     * The list of comics that belongs to the character.
     */
    private List<Comics> comics;
    /**
     * The character ID that belongs to the character.
     */
    private int id;
    /**
     * The character name.
     */
    private String name;
    /**
     * The character background information.
     */
    private String background;
    /**
     * The character image's url.
     */
    private String imageUrl;
    /**
     * Empty constructor.
     */
    MarvelCharacters() {
        comics = new ArrayList<>();
        id = 0;
        name = "none";
        background = "none";
    }

    /**
     * Getter for ID.
     */
    public int getId() {
        return id;
    }
    /**
     * Getter for comics.
     */
    public List<Comics> getComics() {
        return comics;
    }
    /**
     * Getter for Background.
     */
    public String getBackground() {
        return background;
    }
    /**
     * Getter for Name.
     */
    public String getName() {
        return name;
    }
    /**
     * Getter for Image.
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Setter for background.
     */
    public void setBackground(String background) {
        this.background = background;
    }

    /**
     * Setter for comics.
     */
    public void setComics(List<Comics> comics) {
        this.comics = comics;
    }

    /**
     * Setter for ID.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Setter for name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for Image.
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl + "/standard_small.jpg";
    }
}
