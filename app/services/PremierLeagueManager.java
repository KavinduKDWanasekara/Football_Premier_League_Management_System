package services;

import entities.FootballClub;
import entities.FootballSchoolClub;
import entities.FootballUniversityClub;
import entities.Match;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PremierLeagueManager implements LeagueManager{

    public static List <FootballClub> footballClubList = new ArrayList<>();
    public static List <Match> matchList = new ArrayList<>();

    @Override
    public void addFootballClub(FootballClub footballClub) {
        footballClubList.add(footballClub);
    }

    @Override
    public void deleteFootballClub(String clubName) {

        for (FootballClub footballClub :  footballClubList){
            if (footballClub.getClubName().equals(clubName)){
                footballClubList.remove(footballClub);
                break;
            }
        }
    }

    @Override
    public void displayStatics(String clubName) {
        for (FootballClub footballClub :  footballClubList){
            if (footballClub.getClubName().equals(clubName)){
                System.out.println(footballClub);
                break;

            }
        }

    }

    @Override
    public void displayTable() {
        Collections.sort(footballClubList);
        System.out.println("------------------------------------------------------------------------------------------" +
                "--------------------------------------------------------------");
        System.out.printf("%20s %1s %12s %1s %2s %1s %5s %1s %5s %1s %5s %1s %5s %1s %5s %1s %5s %1s %12s %1s %12s %1s ", "Club Name", "|", "Matches Played", "|", "Wins",
                "|", "Defeats", "|", "Draws", "|", "Goals Received", "|", "Goals Scored", "|", "Goal Difference", "|", "Club Points", "|", "School Name", "|", "University Name","|\n");
        System.out.println("------------------------------------------------------------------------------------------" +
                "--------------------------------------------------------------");
        for (FootballClub eachFootballClub : footballClubList) {
            if (eachFootballClub instanceof FootballUniversityClub){
                System.out.printf("%20s %1s %8s %7s %3s %2s %4s %4s %3s %3s %8s %7s %7s %6s %8s %8s %7s %5s %25s %7s %n",
                        eachFootballClub.getClubName(),"|", eachFootballClub.getNumberOfMatches(), "|", eachFootballClub.getNumOfWins(),
                        "|", eachFootballClub.getNumOfDefeats(), "|", eachFootballClub.getNumOfDraws(), "|",
                        eachFootballClub.getNumOfGoalsReceived(), "|", eachFootballClub.getNumOfGoalsScored(), "|",
                        eachFootballClub.getGoalDifference(), "|", eachFootballClub.getToPoints(), "|", ((FootballUniversityClub) eachFootballClub).getUniName(),"|");
            } else if (eachFootballClub instanceof FootballSchoolClub){
                System.out.printf("%20s %1s %8s %7s %3s %2s %4s %4s %3s %3s %8s %7s %7s %6s %8s %8s %7s %5s %12s %1s %n",
                        eachFootballClub.getClubName(),"|", eachFootballClub.getNumberOfMatches(), "|", eachFootballClub.getNumOfWins(),
                        "|", eachFootballClub.getNumOfDefeats(), "|", eachFootballClub.getNumOfDraws(), "|",
                        eachFootballClub.getNumOfGoalsReceived(), "|", eachFootballClub.getNumOfGoalsScored(), "|",
                        eachFootballClub.getGoalDifference(), "|", eachFootballClub.getToPoints(), "|", ((FootballSchoolClub) eachFootballClub).getSclName(),"|");
            } else {
                System.out.printf("%20s %1s %8s %7s %3s %2s %4s %4s %3s %3s %8s %7s %7s %6s %8s %8s %7s %5s  %n",
                        eachFootballClub.getClubName(),"|", eachFootballClub.getNumberOfMatches(), "|", eachFootballClub.getNumOfWins(),
                        "|", eachFootballClub.getNumOfDefeats(), "|", eachFootballClub.getNumOfDraws(), "|",
                        eachFootballClub.getNumOfGoalsReceived(), "|", eachFootballClub.getNumOfGoalsScored(), "|",
                        eachFootballClub.getGoalDifference(), "|", eachFootballClub.getToPoints(), "|");
            }

        }
        System.out.println("-------------------------------------------------------------------------------------------" +
                "--------------------------------------------------------------");

    }

    @Override
    public void addAPlayedMatch(Match newMatch) {
        matchList.add(newMatch);
        FootballClub team1 = null ;
        FootballClub team2 = null ;

        for (FootballClub footballClub : footballClubList){
            if (footballClub.getClubName().equals(newMatch.getTeam1())){
                team1 = footballClub;
            }else if (footballClub.getClubName().equals(newMatch.getTeam2())){
                team2 = footballClub;
            }
        }
        try {
            if (newMatch.getTeam1Goals()>newMatch.getTeam2Goals()){
                team1.setNumOfWins(team1.getNumOfWins()+1);
                team2.setNumOfDefeats(team2.getNumOfDefeats()+1);
                team1.setNumOfGoalsReceived(team1.getNumOfGoalsReceived()+newMatch.getTeam2Goals());
                team1.setNumOfGoalsScored(team1.getNumOfGoalsScored()+newMatch.getTeam1Goals());
                team2.setNumOfGoalsReceived(team2.getNumOfGoalsReceived()+newMatch.getTeam1Goals());
                team2.setNumOfGoalsScored(team2.getNumOfGoalsScored()+newMatch.getTeam2Goals());
                team1.setNumberOfMatches(team1.getNumberOfMatches()+1);
                team2.setNumberOfMatches(team2.getNumberOfMatches()+1);
                team1.setToPoints(team1.getToPoints()+3);
            } else if (newMatch.getTeam2Goals()>newMatch.getTeam1Goals()){
                team2.setNumOfWins(team2.getNumOfWins()+1);
                team1.setNumOfDefeats(team1.getNumOfDefeats()+1);
                team2.setNumOfGoalsReceived(team2.getNumOfGoalsReceived()+newMatch.getTeam1Goals());
                team1.setNumOfGoalsScored(team2.getNumOfGoalsScored()+newMatch.getTeam2Goals());
                team1.setNumOfGoalsReceived(team1.getNumOfGoalsReceived()+newMatch.getTeam2Goals());
                team2.setNumOfGoalsScored(team2.getNumOfGoalsScored()+newMatch.getTeam2Goals());
                team1.setNumberOfMatches(team1.getNumberOfMatches()+1);
                team2.setNumberOfMatches(team2.getNumberOfMatches()+1);
                team2.setToPoints(team2.getToPoints()+3);
            } else {
                team1.setNumOfDraws(team1.getNumOfDraws()+1);
                team1.setNumOfGoalsReceived(team1.getNumOfGoalsReceived()+newMatch.getTeam2Goals());
                team1.setNumOfGoalsScored(team1.getNumOfGoalsScored()+newMatch.getTeam1Goals());
                team1.setToPoints(team1.getToPoints()+1);
                team1.setNumberOfMatches(team1.getNumberOfMatches()+1);
                team2.setNumOfDraws(team2.getNumOfDraws()+1);
                team2.setNumOfGoalsReceived(team2.getNumOfGoalsReceived()+newMatch.getTeam1Goals());
                team2.setNumOfGoalsScored(team2.getNumOfGoalsScored()+newMatch.getTeam2Goals());
                team2.setToPoints(team2.getToPoints()+1);
                team2.setNumberOfMatches(team2.getNumberOfMatches()+1);
            }
        } catch (NullPointerException e){
            System.out.println(" ");
        }
    }

    public void writeClubStatics(String x) throws IOException {

        FileOutputStream fo = new FileOutputStream(x);
        ObjectOutputStream o = new ObjectOutputStream(fo);

        for (FootballClub footballClub : footballClubList){
            o.writeObject(footballClub);
        }

        o.flush();
        o.close();
        fo.close();
    }

    public void writeMatchStatics(String x) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(x);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for (Match match  : matchList){
            objectOutputStream.writeObject(match);
        }
    }


    public void readClubStatics(String y) throws IOException, ClassNotFoundException{

        footballClubList.clear();
        FileInputStream fi = new FileInputStream(y);
        ObjectInputStream ois = new ObjectInputStream(fi);

        for (; ;){
            try {
                FootballClub footballClub = (FootballClub) ois.readObject();
                footballClubList.add(footballClub);
                System.out.println(footballClub);

            }catch (EOFException e){
                break;
            }
        }
    }

    public void readMatchStatics(String y) throws IOException, ClassNotFoundException{

        FileInputStream fi = new FileInputStream(y);
        ObjectInputStream ois = new ObjectInputStream(fi);

        for (; ;){
            try {
                Match match = (Match) ois.readObject();
                matchList.add(match);
                System.out.println(match);

            }catch (EOFException e){
                break;
            }
        }
    }




}

