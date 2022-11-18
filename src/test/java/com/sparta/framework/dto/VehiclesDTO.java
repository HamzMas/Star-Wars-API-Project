package com.sparta.framework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class VehiclesDTO {
    @JsonProperty("max_atmosphering_speed")
    private int maxAtmospheringSpeed;

    @JsonProperty("cargo_capacity")
    private int cargoCapacity;

    @JsonProperty("films")
    private List<String> films;

    @JsonProperty("passengers")
    private int passengers;

    @JsonProperty("pilots")
    private List<Object> pilots;

    @JsonProperty("edited")
    private Date edited;

    @JsonProperty("consumables")
    private String consumables;

    @JsonProperty("created")
    private Date created;

    @JsonProperty("length")
    private double length;

    @JsonProperty("url")
    private String url;

    @JsonProperty("manufacturer")
    private String manufacturer;

    @JsonProperty("crew")
    private int crew;

    @JsonProperty("vehicle_class")
    private String vehicleClass;

    @JsonProperty("cost_in_credits")
    private int costInCredits;

    @JsonProperty("name")
    private String name;

    @JsonProperty("model")
    private String model;

    public int getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public List<String> getFilms() {
        return films;
    }

    public int getPassengers() {
        return passengers;
    }

    public List<Object> getPilots() {
        return pilots;
    }

    public Date getEdited() {
        return edited;
    }

    public String getConsumables() {
        return consumables;
    }

    public Date getCreated() {
        return created;
    }

    public double getLength() {
        return length;
    }

    public String getUrl() {
        return url;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getCrew() {
        return crew;
    }

    public String getVehicleClass() {
        return vehicleClass;
    }

    public int getCostInCredits() {
        return costInCredits;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
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
