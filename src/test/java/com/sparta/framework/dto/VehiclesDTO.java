package com.sparta.framework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class VehiclesDTO {
    @JsonProperty("max_atmosphering_speed")
    private String maxAtmospheringSpeed;

    @JsonProperty("cargo_capacity")
    private String cargoCapacity;

    @JsonProperty("films")
    private List<String> films;

    @JsonProperty("passengers")
    private String passengers;

    @JsonProperty("pilots")
    private List<Object> pilots;

    @JsonProperty("edited")
    private String edited;

    @JsonProperty("consumables")
    private String consumables;

    @JsonProperty("created")
    private String created;

    @JsonProperty("length")
    private String length;

    @JsonProperty("url")
    private String url;

    @JsonProperty("manufacturer")
    private String manufacturer;

    @JsonProperty("crew")
    private String crew;

    @JsonProperty("vehicle_class")
    private String vehicleClass;

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

    public List<Object> getPilots(){
        return pilots;
    }

    public String getEdited(){
        return edited;
    }

    public String getConsumables(){
        return consumables;
    }

    public String getCreated(){
        return created;
    }

    public String getLength(){
        return length;
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

    public String getVehicleClass(){
        return vehicleClass;
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
                "Vehicles{" +
                        "max_atmosphering_speed = '" + maxAtmospheringSpeed + '\'' +
                        ",cargo_capacity = '" + cargoCapacity + '\'' +
                        ",films = '" + films + '\'' +
                        ",passengers = '" + passengers + '\'' +
                        ",pilots = '" + pilots + '\'' +
                        ",edited = '" + edited + '\'' +
                        ",consumables = '" + consumables + '\'' +
                        ",created = '" + created + '\'' +
                        ",length = '" + length + '\'' +
                        ",url = '" + url + '\'' +
                        ",manufacturer = '" + manufacturer + '\'' +
                        ",crew = '" + crew + '\'' +
                        ",vehicle_class = '" + vehicleClass + '\'' +
                        ",cost_in_credits = '" + costInCredits + '\'' +
                        ",name = '" + name + '\'' +
                        ",model = '" + model + '\'' +
                        "}";
    }
}
