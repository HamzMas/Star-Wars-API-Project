package com.sparta.framework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;

public class FilmsDTO {

    @JsonProperty("title")
    private String title;

    @JsonProperty("episode_id")
    private int episodeId;

    @JsonProperty("opening_crawl")
    private String openingCrawl;

    @JsonProperty("director")
    private String director;

    @JsonProperty("producer")
    private String producer;

    @JsonProperty("release_date")
    private Date releaseDate;

    @JsonProperty("characters")
    private List<String> characters;

    @JsonProperty("planets")
    private List<String> planets;

    @JsonProperty("starships")
    private List<String> starships;

    @JsonProperty("vehicles")
    private List<String> vehicles;

    @JsonProperty("species")
    private List<String> species;

    @JsonProperty("created")
    private Date created;

    @JsonProperty("edited")
    private Date edited;

    @JsonProperty("url")
    private String url;

    public String getTitle(){
        return title;
    }

    public int getEpisodeId(){
        return episodeId;
    }

    public String getOpeningCrawl(){
        return openingCrawl;
    }

    public String getDirector(){
        return director;
    }

    public String getProducer(){
        return producer;
    }

    public Date getReleaseDate(){
        return releaseDate;
    }

    public List<String> getCharacters(){
        return characters;
    }

    public List<String> getPlanets(){
        return planets;
    }

    public List<String> getStarships(){
        return starships;
    }

    public List<String> getVehicles(){
        return vehicles;
    }

    public List<String> getSpecies(){
        return species;
    }

    public Date getCreated(){
        return created;
    }

    public Date getEdited(){
        return edited;
    }

    public String getUrl(){
        return url;
    }


    @Override
    public String toString(){
        return
                "Films{" +
                        "edited = '" + edited + '\'' +
                        ",director = '" + director + '\'' +
                        ",created = '" + created + '\'' +
                        ",vehicles = '" + vehicles + '\'' +
                        ",opening_crawl = '" + openingCrawl + '\'' +
                        ",title = '" + title + '\'' +
                        ",url = '" + url + '\'' +
                        ",characters = '" + characters + '\'' +
                        ",episode_id = '" + episodeId + '\'' +
                        ",planets = '" + planets + '\'' +
                        ",release_date = '" + releaseDate + '\'' +
                        ",starships = '" + starships + '\'' +
                        ",species = '" + species + '\'' +
                        ",producer = '" + producer + '\'' +
                        "}";
    }
}
