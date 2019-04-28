package com.example.marvecomicssearch;
public class Comics {
    private String resourceURI;
    private String comicName;

    public String getComicName() {
        return comicName;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setComicName(String comicName) {
        this.comicName = comicName;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }
}
