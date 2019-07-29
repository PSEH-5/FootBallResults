package com.anshika.football.footballresultsservice.service;

import com.anshika.football.footballresultsservice.model.TeamStanding;

public interface IFootballService {

    TeamStanding getResults(String country, String league, String team);


}

