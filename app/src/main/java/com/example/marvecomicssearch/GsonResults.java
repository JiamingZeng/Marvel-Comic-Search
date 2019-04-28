package com.example.marvecomicssearch;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.List;
import java.util.ArrayList;
import com.example.marvecomicssearch.MarvelCharacters;
public class GsonResults {
    /**
     * Internally stored a list of characters.
     */
    private List<MarvelCharacters> charactersList;

    /**
     * Get characters in a list whose names from json.
     */
    public List<MarvelCharacters> getCharactersList() {
        return charactersList;
    }

    /**
     * Set characters in a list whose names from json.
     * @param json - the JSON string returned by the Marvel API
     */
    public void setCharacters(final String json) {
        List<MarvelCharacters> toReturn = new ArrayList<>();
        JsonParser parser = new JsonParser();
        // get all the characters' information as json;
        JsonObject allCharacters = parser.parse(json).getAsJsonObject();
        JsonArray characters = allCharacters.getAsJsonObject("data").getAsJsonArray("results");
        int count = 0;
        for (JsonElement character : characters) {
            count++;
            if (count > 10 || count > characters.size()) {
                break;
            }
            JsonObject individualCharacter = character.getAsJsonObject();
            MarvelCharacters hero = new MarvelCharacters();

            hero.setComics(returnComics(individualCharacter.get("comics").getAsJsonObject()));

            hero.setId(individualCharacter.get("id").getAsInt());

            hero.setBackground(individualCharacter.get("description").getAsString());

            hero.setName(individualCharacter.get("name").getAsString());

            hero.setImageUrl(individualCharacter.get("thumbnail").
                        getAsJsonObject().get("path").getAsString());

            toReturn.add(hero);
        }
        charactersList = toReturn;
    }

    /**
     * A helper function to return a list comic books' information.
     * @param characterComics - the JsonObject from character information.
     * @return list of comics.
     */
    public static List<Comics> returnComics(final JsonObject characterComics) {
        List<Comics> toReturn = new ArrayList<>();
        JsonArray comics = characterComics.get("items").getAsJsonArray();
        int count = 0;
        for (JsonElement comic : comics) {
            count++;
            if (count > 10 || count > comics.size()) {
                break;
            }
            Comics comicBook = new Comics();
            JsonObject individualComic = comic.getAsJsonObject();
            comicBook.setComicName(individualComic.get("name").getAsString());
            comicBook.setResourceURI(individualComic.get("resourceURI").getAsString());
            toReturn.add(comicBook);
        }
        return toReturn;
    }


    /**
     * A helper function to return a specific marvel character.
     * @param charactersList - a list of characters
     * @param heroNo - the number of hero
     * @return a character.
     */
    public static MarvelCharacters findCharacter(List<MarvelCharacters> charactersList, int heroNo) {
        if (charactersList == null || heroNo > 10 || heroNo > charactersList.size()) {
            return null;
        }
        return charactersList.get(heroNo);
    }
    /**
     * A helper function to return a specific marvel character.
     * @param hero - a specific marvel character
     * @param comicNo - the number of comic book
     * @return a comic book.
     */
    public static Comics findComic(MarvelCharacters hero, int comicNo) {
        if (hero == null || comicNo > 10 || comicNo > hero.getComics().size()) {
            return null;
        }
        return hero.getComics().get(comicNo);
    }
}
