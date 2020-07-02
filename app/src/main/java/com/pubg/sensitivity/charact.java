package com.pubg.sensitivity;

public class charact {
    String player;
    String character;

    public charact() {
    }

    public charact(String player, String character) {
        this.player = player;
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
}
