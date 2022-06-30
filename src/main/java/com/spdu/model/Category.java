package com.spdu.model;

public enum Category {

    MEAT("м'ясо"),
    FISH("риба"),
    SOUCE("соуси"),
    GROCERY("бакалія"),
    VEGETABLES("овочі"),
    FRUITS("фрукти"),
    SPICES("спеції"),
    BAKERY("випічка"),
    DAIRY("молочка");

    private final String title;

    Category(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
