package com.sparta.framework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.framework.connection.ConnectionManager;
import io.cucumber.java.sl.In;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

public class StarshipsDTO {
    List<StarshipsDTO> dtos = new ArrayList<>();


    @JsonProperty("max_atmosphering_speed")
    private String maxAtmospheringSpeed;

    @JsonProperty("cargo_capacity")
    private String cargoCapacity;

    @JsonProperty("films")
    private List<String> films;

    @JsonProperty("passengers")
    private String passengers;

    @JsonProperty("pilots")
    private List<String> pilots;

    @JsonProperty("edited")
    private Date edited;

    @JsonProperty("consumables")
    private String consumables;

    @JsonProperty("MGLT")
    private Integer mGLT;

    @JsonProperty("created")
    private Date created;

    @JsonProperty("length")
    private Double length;

    @JsonProperty("starship_class")
    private String starshipClass;

    @JsonProperty("url")
    private String url;

    @JsonProperty("manufacturer")
    private String manufacturer;

    @JsonProperty("crew")
    private String crew;

    @JsonProperty("hyperdrive_rating")
    private Double hyperdriveRating;

    @JsonProperty("cost_in_credits")
    private String costInCredits;

    @JsonProperty("name")
    private String name;

    @JsonProperty("model")
    private String model;

    public String getMaxAtmospheringSpeed(){
        return maxAtmospheringSpeed;
    }

    public String getCargoCapacity(){
        return cargoCapacity;
    }

    public List<String> getFilms(){
        return films;
    }

    public String getPassengers(){
        return passengers;
    }

    public List<String> getPilots(){
        return pilots;
    }

    public Date getEdited(){
        return edited;
    }

    public String getConsumables(){
        return consumables;
    }

    public Integer getMGLT(){
        return mGLT;
    }

    public Date getCreated(){
        return created;
    }

    public Double getLength(){
        return length;
    }

    public String getStarshipClass(){
        return starshipClass;
    }

    public String getUrl(){
        return url;
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public String getCrew(){
        return crew;
    }

    public Double getHyperdriveRating(){
        return hyperdriveRating;
    }

    public String getCostInCredits(){
        return costInCredits;
    }

    public String getName(){
        return name;
    }

    public String getModel(){
        return model;
    }

    @Override
    public String toString(){
        return
                "Response{" +
                        "max_atmosphering_speed = '" + maxAtmospheringSpeed + '\'' +
                        ",cargo_capacity = '" + cargoCapacity + '\'' +
                        ",films = '" + films + '\'' +
                        ",passengers = '" + passengers + '\'' +
                        ",pilots = '" + pilots + '\'' +
                        ",edited = '" + edited + '\'' +
                        ",consumables = '" + consumables + '\'' +
                        ",mGLT = '" + mGLT + '\'' +
                        ",created = '" + created + '\'' +
                        ",length = '" + length + '\'' +
                        ",starship_class = '" + starshipClass + '\'' +
                        ",url = '" + url + '\'' +
                        ",manufacturer = '" + manufacturer + '\'' +
                        ",crew = '" + crew + '\'' +
                        ",hyperdrive_rating = '" + hyperdriveRating + '\'' +
                        ",cost_in_credits = '" + costInCredits + '\'' +
                        ",name = '" + name + '\'' +
                        ",model = '" + model + '\'' +
                        "}";
    }


    public boolean isNumberFormatted(String number){
        //Check the number uses "," as thousands separators
        System.out.println("Number of crew:" + crew);
        return number.matches("\\d{1,3}(,\\d{3})*");
    }

    public boolean isDateInPast(Date date){
        Date now = new Date();
        return date.before(now);

    }

    public boolean isConsumablesFormatCorrect(){
        String[] splitConsumables = consumables.split(" ");
        if (splitConsumables[0].equals("1")){
            return splitConsumables[1].equals("day") || splitConsumables[1].equals("week") || splitConsumables[1].equals("month") || splitConsumables[1].equals("year");
        } else {
            return splitConsumables[1].equals("days") || splitConsumables[1].equals("weeks") || splitConsumables[1].equals("months") || splitConsumables[1].equals("years");
        }
    }

    public boolean isCostNumberLargerThanZero(){
        if (!costInCredits.equals("unknown")){
            return Long.parseLong(costInCredits) > 0;
        }
        System.out.println("Cost in credits is unknown");
        return true;

    }


}
