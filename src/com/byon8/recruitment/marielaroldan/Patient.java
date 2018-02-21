package com.byon8.recruitment.marielaroldan;

import java.util.UUID;

public class Patient {

    private static String id;
    private String name;
    private String chronicDisease;
    private String allergies;
    private String painPlace;

    public Patient(String name, String allergies, String chronicDisease, String painPlace) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.allergies = allergies;
        this.chronicDisease = chronicDisease;
        this.painPlace = painPlace;
    }

    public Patient() {

    }

    public static String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChronicDisease() {
        return chronicDisease;
    }

    public void setChronicDisease(String chronicDisease) {
        this.chronicDisease = chronicDisease;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getPainPlace() {
        return painPlace;
    }

    public void setPainPlace(String painPlace) {
        this.painPlace = painPlace;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", chronicDisease='" + valueToString(chronicDisease) + '\'' +
                ", allergies='" + valueToString(allergies) + '\'' +
                ", painPlace='" + valueToString(painPlace) + '\'' +
                '}';
    }

    //Todo: Replace custom generation with library
    public String toJson() {

        return "{" +
                "\"id\":" + "\"" + id + "\"," +
                "\"name\":" + "\"" + name + "\"," +
                "\"allergies\":" + "\"" + valueToString(allergies) + "\"," +
                "\"chronicDisease\":" + "\"" + valueToString(chronicDisease) + "\"," +
                "\"painPlace\":" + "\"" + valueToString(painPlace) + "\"" +
                "}";
    }

    /**
     * Replace null values with N/A (Not Applicable)
     * @param value the value to transform
     * @return N/A if value is null or else the value itself
     */
    private String valueToString(String value) {
        return (value == null) ? "N/A" : value;
    }
}
