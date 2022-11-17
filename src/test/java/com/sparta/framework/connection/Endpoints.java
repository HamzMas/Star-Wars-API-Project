package com.sparta.framework.connection;

public enum Endpoints {
    BASEURL("https://swapi.dev/api/"),
    FILMS(BASEURL + "films/"),
    PEOPLE(BASEURL + "people/"),
    PLANETS(BASEURL + "planets/"),
    SPECIES(BASEURL + "species/"),
    STARSHIPS(BASEURL + "starships/"),
    VEHICLES(BASEURL + "vehicles/");

    private String url;
    public String getUrl(){
        return url;
    }

    Endpoints(String url) {
        this.url = url;
    }
}
