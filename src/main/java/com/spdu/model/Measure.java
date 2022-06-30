package com.spdu.model;

public enum Measure {

    KILOGRAM("кг"),
    LITER("л"),
    PACK("уп"),
    PIECE("шт");

    private final String title;

    Measure(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
