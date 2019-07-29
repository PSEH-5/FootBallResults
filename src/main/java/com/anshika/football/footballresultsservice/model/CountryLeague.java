package com.anshika.football.footballresultsservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CountryLeague {
    private String country_id;
    private String country_name;
    private String league_id;
    private String league_name;
    private String league_season;



    public CountryLeague()
    {

    }


    public CountryLeague(String country_id, String country_name, String league_id, String league_name, String league_season) {
        this.country_id = country_id;
        this.country_name = country_name;
        this.league_id = league_id;
        this.league_name = league_name;
        this.league_season = league_season;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getLeague_id() {
        return league_id;
    }

    public void setLeague_id(String league_id) {
        this.league_id = league_id;
    }

    public String getLeague_name() {
        return league_name;
    }

    public void setLeague_name(String league_name) {
        this.league_name = league_name;
    }

    public String getLeague_season() {
        return league_season;
    }

    public void setLeague_season(String league_season) {
        this.league_season = league_season;
    }

}
