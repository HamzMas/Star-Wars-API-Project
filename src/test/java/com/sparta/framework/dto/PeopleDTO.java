package com.sparta.framework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.framework.utilities.LinkValidator;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class PeopleDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("height")
    private int height;

    @JsonProperty("mass")
    private int mass;

    @JsonProperty("hair_color")
    private String hairColor;

    @JsonProperty("skin_color")
    private String skinColor;

    @JsonProperty("eye_color")
    private String eyeColor;

    @JsonProperty("birth_year")
    private String birthYear;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("homeworld")
    private String homeworld;

    @JsonProperty("films")
    private List<String> films;

    @JsonProperty("species")
    private List<String> species;

    @JsonProperty("vehicles")
    private List<String> vehicles;

    @JsonProperty("starships")
    private List<String> starships;

    @JsonProperty("created")
    private Date created;

    @JsonProperty("edited")
    private Date edited;

    @JsonProperty("url")
    private String url;

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getMass() {
        return mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getGender() {
        return gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public List<String> getFilms() {
        return films;
    }

    public List<String> getSpecies() {
        return species;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public List<String> getStarships() {
        return starships;
    }

    public Date getCreated() {
        return created;
    }

    public Date getEdited() {
        return edited;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString(){
        return
                "People{" +
                        "films = '" + films + '\'' +
                        ",homeworld = '" + homeworld + '\'' +
                        ",gender = '" + gender + '\'' +
                        ",skin_color = '" + skinColor + '\'' +
                        ",edited = '" + edited + '\'' +
                        ",created = '" + created + '\'' +
                        ",mass = '" + mass + '\'' +
                        ",vehicles = '" + vehicles + '\'' +
                        ",url = '" + url + '\'' +
                        ",hair_color = '" + hairColor + '\'' +
                        ",birth_year = '" + birthYear + '\'' +
                        ",eye_color = '" + eyeColor + '\'' +
                        ",species = '" + species + '\'' +
                        ",starships = '" + starships + '\'' +
                        ",name = '" + name + '\'' +
                        ",height = '" + height + '\'' +
                        "}";
    }

    public boolean hasPositiveMass(){
        return mass >= 0;
    }

    public boolean isMaleOrFemale(){
        return Objects.equals(gender, "male") || Objects.equals(gender, "female");
    }

    public boolean isBirthYearValid(){
        return birthYear.contains("BBY")  || gender.contains("ABY");
    }

    public boolean checkStatusCode(String url){
       return LinkValidator.checkIfHateoasReturn200StatusCode(url);
    }

    public boolean checkStatusCode(List<String> urls){
        return LinkValidator.checkIfHateoasReturn200StatusCode(urls);
    }
}