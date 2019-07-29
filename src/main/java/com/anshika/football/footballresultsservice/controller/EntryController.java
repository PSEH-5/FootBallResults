package com.anshika.football.footballresultsservice.controller;


import com.anshika.football.footballresultsservice.model.TeamStanding;
import com.anshika.football.footballresultsservice.service.ApiFootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/football")
public class EntryController {

@Autowired
    ApiFootballService footballService;

    @RequestMapping("/{country}/{league}/{team}")
    public TeamStanding getResults(@PathVariable("country") String countryName,@PathVariable("league") String leagueName,@PathVariable("team") String teamName)
    {
        TeamStanding standing  = null;
        try {
             standing = footballService.getResults(countryName, leagueName, teamName);
        }
        catch (Exception e)
        {
            System.out.println(" Error while getting the results: "+ e.getMessage());

        }
        return standing;
    }

}
