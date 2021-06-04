package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.Date;
import entities.Match;
import play.libs.Json;
import play.mvc.*;
import services.PremierLeagueManager;
import utilities.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class HomeController extends Controller {

    PremierLeagueManager premierLeagueManager = new PremierLeagueManager();

//    public HomeController() throws IOException, ClassNotFoundException {
//    }

    //    public Result appSummary() {
//        JsonNode jsonNode = Json.toJson(new AppSummary("Java Play Angular Seed"));
//        return ok(jsonNode).as("application/json");
//    }
//
//    public Result postTest() {
//        JsonNode jsonNode = Json.toJson(new AppSummary("Post Request Test => Data Sending Success"));
//        return ok(jsonNode).as("application/json");
//    }
public void readData() {
    try {
        premierLeagueManager.readClubStatics("ClubStatics.txt");
        premierLeagueManager.readMatchStatics("MatchStatics.txt");
    } catch (ClassNotFoundException | IOException error) {
        System.out.println("Not found");
    }
}
    public Result clubData() {
        PremierLeagueManager.footballClubList.clear();
        System.out.println("jddjd"+PremierLeagueManager.footballClubList);
        readData();
        JsonNode premierLeagueData = utils.methodX((ArrayList) PremierLeagueManager.footballClubList);
        System.out.println("---------------------------------");
        System.out.println(PremierLeagueManager.footballClubList);
//        System.out.println(premierLeagueData.toString());
        return ok(premierLeagueData);
    }

    public Result matchData() {
        PremierLeagueManager.matchList.clear();
        readData();
        JsonNode premierLeagueData = utils.methodX((ArrayList) PremierLeagueManager.matchList);
        System.out.println("---------------------------------");
        System.out.println(PremierLeagueManager.matchList);
//        System.out.println(premierLeagueData.toString());
        return ok(premierLeagueData);

    }

    public Result genMatch() throws IOException, ClassNotFoundException {

        Random randClub=new Random();
        String team01=premierLeagueManager.footballClubList.get(randClub.nextInt(premierLeagueManager.footballClubList.size())).getClubName();
        String team02 ;
        // do while for to avoid the generating same name for the team 2
        do {
            team02 = premierLeagueManager.footballClubList.get(randClub.nextInt(premierLeagueManager.footballClubList.size())).getClubName();
        }while (team01.equals(team02));
        Random randNum=new Random();
        Date date=new Date(randNum.nextInt(31),randNum.nextInt(12),2021);
        int team01GoalCount=randNum.nextInt(30);
        int team02GoalCount=randNum.nextInt(30);
        Match randMatch=new Match(team01, team02,team01GoalCount,team02GoalCount,date);
        premierLeagueManager.addAPlayedMatch(randMatch);

        premierLeagueManager.writeMatchStatics("MatchStatics.txt");
        premierLeagueManager.writeClubStatics("ClubStatics.txt");

        JsonNode premierLeagueData = utils.methodX((ArrayList) PremierLeagueManager.matchList);
        return ok(premierLeagueData).as("application/json");

    }
}
