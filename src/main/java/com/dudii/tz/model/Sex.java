package com.dudii.tz.model;

import java.util.Locale;

public enum Sex {
    MALE("MALE"), FEMALE("FEMALE");

    String sex;
    Sex(String sex){
        this.sex = sex.toUpperCase(Locale.ROOT);
    }
}
