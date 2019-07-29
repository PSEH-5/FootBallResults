package com.anshika.football.footballresultsservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TeamStanding {

    private String country_name;
    private String league_name;

    private String country_id;
    private String league_id;


    private String team_id;
    private String team_name;

    private String overall_league_position;
    private String error;

    public TeamStanding() {
    }

    public TeamStanding(String country_name, String league_name, String country_id, String league_id, String team_id, String team_name, String overall_league_position, String error) {
        this.country_name = country_name;
        this.league_name = league_name;
        this.country_id = country_id;
        this.league_id = league_id;
        this.team_id = team_id;
        this.team_name = team_name;
        this.overall_league_position = overall_league_position;
        this.error = error;
    }



    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getLeague_name() {
        return league_name;
    }

    public void setLeague_name(String league_name) {
        this.league_name = league_name;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getLeague_id() {
        return league_id;
    }

    public void setLeague_id(String league_id) {
        this.league_id = league_id;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getOverall_league_position() {
        return overall_league_position;
    }

    public void setOverall_league_position(String overall_league_position) {
        this.overall_league_position = overall_league_position;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}