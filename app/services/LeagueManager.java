package services;

import entities.FootballClub;
import entities.Match;

import java.io.IOException;

public interface LeagueManager {
    void addFootballClub(FootballClub footballClub);
    void deleteFootballClub(String clubName);
    void displayStatics(String clubName);
    void displayTable();
    void addAPlayedMatch(Match newMatch);
    void writeClubStatics(String x) throws IOException;
    void writeMatchStatics(String x) throws IOException;
    void readClubStatics(String y) throws IOException, ClassNotFoundException;
    void readMatchStatics(String y) throws IOException, ClassNotFoundException;


}
