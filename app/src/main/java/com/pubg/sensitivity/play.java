package com.pubg.sensitivity;

public class play {

    String name;
    String image;



    public play() {
    }

    @Override
    public String toString() {
        return "play{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public play(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}


