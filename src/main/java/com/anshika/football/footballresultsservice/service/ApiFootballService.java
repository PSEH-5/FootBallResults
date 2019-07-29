package com.anshika.football.footballresultsservice.service;

import com.anshika.football.footballresultsservice.model.*;
import com.anshika.football.footballresultsservice.model.CountryLeague;
import com.anshika.football.footballresultsservice.model.TeamStanding;
import com.anshika.football.footballresultsservice.model.configurationValues;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class ApiFootballService implements IFootballService {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    configurationValues configValues;


    @Override
    public TeamStanding getResults(String country, String league, String team) {
        TeamStanding teamRes = new TeamStanding();
        String country_id , team_id ,league_id ;


        country_id = getCountry(country);
        league_id = getLeague(country_id, league);
        team_id = getTeam(league_id, team);
        teamRes = getStanding(league_id,team_id,country_id);

        return teamRes;

    }


    private String getCountry(String Country)
    {

        if(Country.isEmpty())
            return null;
      String country_id=null;
        List<Country> result = null;
        try {
            String url = configValues.getFootballServiceURI() + configValues.getGetCountriesAction() + configValues.getApiKeyName()
                    + configValues.getApiKeyValue();
            String jsonString = restTemplate().getForObject(url, String.class);
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(jsonString, new TypeReference<List<Country>>() {
            });
            for (Country temp : result) {
                if(temp.getCountry_name().equalsIgnoreCase(Country))
                    country_id=temp.getCountry_id();
            }

        } catch (JsonParseException e) {
            System.out.println("Error while parsing JSON-----" + e.getMessage());
        } catch (JsonMappingException e) {
            System.out.println("Error while mapping JSON-----" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO exception-----" + e.getMessage());
        }
        return country_id;
    }

    private String getLeague(String CountryID, String League)
    {


        if(CountryID.isEmpty() || League.isEmpty())
            return null;

        List<CountryLeague> result = null;
        String league_id=null;
        try {
            String url = configValues.getFootballServiceURI() + configValues.getGetLeagueAction()+"country_id=" +CountryID+"&"+ configValues.getApiKeyName()
                    + configValues.getApiKeyValue();
            String jsonString = restTemplate().getForObject(url, String.class);
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(jsonString, new TypeReference<List<CountryLeague>>() {
            });
            for (CountryLeague temp : result) {
                if(temp.getLeague_name().equalsIgnoreCase(League))
                    league_id=temp.getLeague_id();
            }

        } catch (JsonParseException e) {
            System.out.println("Error while parsing JSON-----" + e.getMessage());
        } catch (JsonMappingException e) {
            System.out.println("Error while mapping JSON-----" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO exception-----" + e.getMessage());
        }
        return league_id;
    }

    private String getTeam(String LeagueID, String Team)
    {


        if(Team.isEmpty() || LeagueID.isEmpty())
            return null;
        List<Team> result = null;
        String team_id=null;
        try {
            String url = configValues.getFootballServiceURI() + configValues.getGetTeamAction()+"league_id=" +LeagueID+"&"+ configValues.getApiKeyName()
                    + configValues.getApiKeyValue();
            String jsonString = restTemplate().getForObject(url, String.class);
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(jsonString, new TypeReference<List<Team>>() {
            });
            for (Team temp : result) {
                if(temp.getTeam_name().equalsIgnoreCase(Team))
                    team_id=temp.getTeam_key();
            }

        } catch (JsonParseException e) {
            System.out.println("Error while parsing JSON-----" + e.getMessage());
        } catch (JsonMappingException e) {
            System.out.println("Error while mapping JSON-----" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO exception-----" + e.getMessage());
        }
        return team_id;
    }
        private  TeamStanding getStanding(String leagueId,String teamId, String countryid) {

            if(leagueId.isEmpty() || teamId.isEmpty() || countryid.isEmpty())
                return null;
        TeamStanding teamStanding =null;
            List<TeamStanding> result = null;
            String team_id=null;
            try {
                String url = configValues.getFootballServiceURI() + configValues.getGetStandings()+"league_id=" +leagueId+"&"+ configValues.getApiKeyName()
                        + configValues.getApiKeyValue();
                String jsonString = restTemplate().getForObject(url, String.class);
                ObjectMapper mapper = new ObjectMapper();
                result = mapper.readValue(jsonString, new TypeReference<List<TeamStanding>>() {
                });
                for (TeamStanding temp : result) {
                    if(temp.getLeague_id().equalsIgnoreCase(leagueId) && temp.getTeam_id().equalsIgnoreCase(teamId))
                        teamStanding=temp;
                }

            } catch (JsonParseException e) {
                System.out.println("Error while parsing JSON-----" + e.getMessage());
            } catch (JsonMappingException e) {
                System.out.println("Error while mapping JSON-----" + e.getMessage());
            } catch (IOException e) {
                System.out.println("IO exception-----" + e.getMessage());
            }
            if(null != teamStanding) {
                teamStanding.setCountry_id(countryid);
            }
        return teamStanding;

        }

    }

