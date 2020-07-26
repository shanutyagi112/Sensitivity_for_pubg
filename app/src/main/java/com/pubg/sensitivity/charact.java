package com.pubg.sensitivity;

public class charact {
    String player;
    String character;
    String search;

    public charact() {
    }

    public charact(String player, String character, String search) {
        this.player = player;
        this.search = search;
        this.character = character;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
