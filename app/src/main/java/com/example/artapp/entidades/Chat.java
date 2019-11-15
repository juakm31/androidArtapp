package com.example.artapp.entidades;

public class Chat {

    private String name;
    private String message;
    private int thumbnail;

    public Chat(String name, String message, int thumbnail) {
        this.name = name;
        this.message = message;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
