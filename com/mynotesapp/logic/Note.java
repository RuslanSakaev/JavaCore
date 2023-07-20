package com.mynotesapp.logic;

public class Note {
    private String text;

    public Note(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }
}
