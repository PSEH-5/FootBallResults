package com.anshika.football.footballresultsservice.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
public class configurationValues {

    @Autowired
    private Environment env;

    private String footballServiceURI;
    private String getCountriesAction;
    private String getLeagueAction;
    private String getTeamAction;
    private String getResults;
    private String apiKeyName;
    private String apiKeyValue;

    private String getStandings;

    public configurationValues() {

        /*this.setFootballServiceURI(env.getProperty("apifootball.uri"));
        this.setGetCountriesAction(env.getProperty("apifootball.uri.getcountries"));
        this.setGetLeagueAction(env.getProperty("apifootball.uri.getcountries"));
        this.setGetTeamAction(env.getProperty("apifootball.uri.getcountries"));
        this.setGetResults(env.getProperty("apifootball.uri.getcountries"));
        this.setApiKeyName(env.getProperty("apifootball.uri.apikeyname"));
        this.setApiKeyValue(env.getProperty("apifootball.uri.apikeyvalue"));*/

        this.setFootballServiceURI("https://apiv2.apifootball.com/?action=");
        this.setGetCountriesAction("get_countries&");
        this.setGetLeagueAction("get_leagues&");
        this.setGetTeamAction("get_teams&");
        this.setGetResults("get_standings&");
        this.setApiKeyName("APIkey=");
        this.setApiKeyValue("9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978");
        this.setGetStandings("get_standings&");


    }

    public configurationValues(String footballServiceURI, String getCountriesAction, String getLeagueAction, String getTeamAction, String getResults, String apiKeyName, String apiKeyValue, String getStandings) {
        this.footballServiceURI = footballServiceURI;
        this.getCountriesAction = getCountriesAction;
        this.getLeagueAction = getLeagueAction;
        this.getTeamAction = getTeamAction;
        this.getResults = getResults;
        this.apiKeyName = apiKeyName;
        this.apiKeyValue = apiKeyValue;
        this.getStandings = getStandings;
    }

    public String getGetStandings() {
        return getStandings;
    }

    public void setGetStandings(String getStandings) {
        this.getStandings = getStandings;
    }

    public Environment getEnv() {
        return env;
    }

    public void setEnv(Environment env) {
        this.env = env;
    }

    public String getFootballServiceURI() {
        return footballServiceURI;
    }

    public void setFootballServiceURI(String footballServiceURI) {
        this.footballServiceURI = footballServiceURI;
    }

    public String getGetCountriesAction() {
        return getCountriesAction;
    }

    public void setGetCountriesAction(String getCountriesAction) {
        this.getCountriesAction = getCountriesAction;
    }

    public String getGetLeagueAction() {
        return getLeagueAction;
    }

    public void setGetLeagueAction(String getLeagueAction) {
        this.getLeagueAction = getLeagueAction;
    }

    public String getGetTeamAction() {
        return getTeamAction;
    }

    public void setGetTeamAction(String getTeamAction) {
        this.getTeamAction = getTeamAction;
    }

    public String getGetResults() {
        return getResults;
    }

    public void setGetResults(String getResults) {
        this.getResults = getResults;
    }

    public String getApiKeyName() {
        return apiKeyName;
    }

    public void setApiKeyName(String apiKeyName) {
        this.apiKeyName = apiKeyName;
    }

    public String getApiKeyValue() {
        return apiKeyValue;
    }

    public void setApiKeyValue(String apiKeyValue) {
        this.apiKeyValue = apiKeyValue;
    }
}



