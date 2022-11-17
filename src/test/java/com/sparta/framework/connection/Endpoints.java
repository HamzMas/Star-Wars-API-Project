package com.sparta.framework.connection;

public enum Endpoints {
    BASEURL("https://swapi.dev/api/"),
    FILMS("https://swapi.dev/api/films/"),
    PEOPLE("https://swapi.dev/api/people/"),
    PLANETS("https://swapi.dev/api/planets/"),
    SPECIES("https://swapi.dev/api/species/"),
    STARSHIPS("https://swapi.dev/api/starships/"),
    VEHICLES("https://swapi.dev/api/vehicles/");

    private String url;


    public String getUrl() {
        return url;
    }

    Endpoints(String url) {
        this.url = url;
    }

}