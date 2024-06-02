package model;

public enum Type {

    WORK("рабочая"), PERSONAL("личная");

    private final String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
