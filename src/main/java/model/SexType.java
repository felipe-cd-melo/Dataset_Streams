package model;

public enum SexType {
    FEMALE("female"),
    MALE("male");

    final private String description;
    SexType(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
}
