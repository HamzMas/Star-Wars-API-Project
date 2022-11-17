package com.sparta.framework.injector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.framework.dto.*;
import io.cucumber.java.tr.Ve;

import java.io.IOException;
import java.net.URL;
public class Injector {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static FilmsDTO injectFilmsDTO(String path)
    {
        FilmsDTO filmDTO = new FilmsDTO();

        try
        {
            filmDTO = mapper.readValue(new URL(path), FilmsDTO.class);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return filmDTO;
    }

    public static PeopleDTO injectPeopleDTO(String path)
    {
        PeopleDTO peopleDTO = new PeopleDTO();

        try
        {
            peopleDTO = mapper.readValue(new URL(path), PeopleDTO.class);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return peopleDTO;
    }

    public static PlanetsDTO injectPlanetsDTO(String path)
    {
        PlanetsDTO planetsDTO = new PlanetsDTO();

        try
        {
            planetsDTO = mapper.readValue(new URL(path), PlanetsDTO.class);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return planetsDTO;
    }

    public static SpeciesDTO injectSpeciesDTO(String path)
    {
        SpeciesDTO speciesDTO = new SpeciesDTO();

        try
        {
            speciesDTO = mapper.readValue(new URL(path), SpeciesDTO.class);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return speciesDTO;
    }

    public static StarshipsDTO injectStarshipsDTO(String path)
    {
        StarshipsDTO starshipsDTO = new StarshipsDTO();

        try
        {
            starshipsDTO = mapper.readValue(new URL(path), StarshipsDTO.class);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return starshipsDTO;
    }

    public static VehiclesDTO injectVehiclesDTO(String path)
    {
        VehiclesDTO vehiclesDTO = new VehiclesDTO();

        try
        {
            vehiclesDTO = mapper.readValue(new URL(path), VehiclesDTO.class);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return vehiclesDTO;
    }


}
