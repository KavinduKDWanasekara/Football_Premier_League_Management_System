package services;

import entities.Date;
import entities.FootballClub;
import entities.Match;
import junit.framework.TestCase;

public class PremierLeagueManagerTest extends TestCase {

    PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
    FootballClub f1 =  new FootballClub("Arsenal","London",100,10,120,55,200);
    Date d1 = new Date(21,12,2021);
    Match m1  = new Match("Aston","Burnley",2,3,d1);
    public void testAddFootballClub() {
        String expectedOutput = "Club Added";
        premierLeagueManager.addFootballClub(f1);
        String actualOutput = "Club Added";
        assertEquals(expectedOutput,actualOutput);
    }

    public void testDeleteFootballClub() {

    }

    public void testAddAPlayedMatch() {
        String expectedOutput = "Match Added";
        premierLeagueManager.addAPlayedMatch(m1);
        String actualOutput = "Match Added";
        assertEquals(expectedOutput,actualOutput);
    }
}