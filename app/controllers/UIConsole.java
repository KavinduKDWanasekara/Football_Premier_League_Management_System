package controllers;

import entities.*;
import services.PremierLeagueManager;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UIConsole {

    static PremierLeagueManager premierLeagueManager = new PremierLeagueManager();

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        FootballClub f1 =  new FootballClub("Arsenal","London",100,10,120,55,200);
//        FootballClub f2 =  new FootballClub("Aston","Birmingham",110,20,110,55,220);
//        FootballClub f3 =  new FootballClub("Burnley","Burnley",120,30,100,60,240);
//        FootballClub f4 =  new FootballClub("Chelsea","London",130,40,90,65,260);
//        FootballClub f5 =  new FootballClub("Crystal","London",140,50,80,70,280);
//        FootballClub f6 =  new FootballClub("Everton","Liverpool",150,60,70,75,300);
//        FootballClub f7 =  new FootballClub("Fulham","London",160,70,60,80,320);
//        FootballClub f8 =  new FootballClub("Leeds","Leeds",170,80,50,85,340);
//        FootballClub f9 =  new FootballClub("Liecester","Liecester",180,90,40,90,360);
//        FootballClub f10 =  new FootballClub("Liverpool","Liverpool",190,100,30,95,380);
//        FootballClub f11 =  new FootballClub("Manchester","OldTafford",200,110,20,100,400);
//        FootballClub f12 =  new FootballClub("Southampton","Southampton",210,120,10,105,420);
//
//
//        premierLeagueManager.addFootballClub(f1);
//        premierLeagueManager.addFootballClub(f2);
//        premierLeagueManager.addFootballClub(f3);
//        premierLeagueManager.addFootballClub(f4);
//        premierLeagueManager.addFootballClub(f5);
//        premierLeagueManager.addFootballClub(f6);
//        premierLeagueManager.addFootballClub(f7);
//        premierLeagueManager.addFootballClub(f8);
//        premierLeagueManager.addFootballClub(f9);
//        premierLeagueManager.addFootballClub(f10);
//        premierLeagueManager.addFootballClub(f11);
//        premierLeagueManager.addFootballClub(f12);



        while (true)  {

            try {
                System.out.println("add a club press 1..");
                System.out.println("remove a club press 2..");
                System.out.println("display statics press 3..");
                System.out.println("premier league manager table press 4..");
                System.out.println("add a played match press 5..");
                System.out.println("To write data in to file press 6..");
                System.out.println("To read data from a file press 7..");
                System.out.println("To open the GUI press 8..");
                System.out.println("To QUIT enter number 0..");
                System.out.print("Enter your choice: ");

                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();


                if (choice == 1) {
                    addClub();
                } else if (choice == 2) {
                    remove();
                } else if (choice == 3) {
                    displayStatics();
                } else if (choice == 4) {
                    premierLeagueTable();
                } else if (choice == 5) {
                    addAPlayedMatch();
                } else if (choice == 6) {
                    fileWrite();

                } else if (choice == 7) {
                    readFile();
                }

                else if (choice==0){
                    System.out.println("Thanks!!");
                    break;
                }else {
                    System.out.println("Invalid Input! Try Again..");
                }
            } catch (InputMismatchException exception1){
                System.out.println("Invalid Input! Try again...");
            } catch (IllegalStateException exceptionI){
                System.out.println("Run from the begin!");
                break;
            }



        }
    }


    public static void addClub(){
        try {
            System.out.println(" ");
            System.out.println(" Football Club = 1 ");
            System.out.println(" University football club = 2");
            System.out.println(" School football club = 3");
            System.out.println(" ");
            System.out.print(" What is your club type? : ");

            Scanner scanner1 = new Scanner(System.in);
            int type = scanner1.nextInt();

            if (type == 1){

                System.out.println("Enter Club name : ");
                String clubName = scanner1.next();
                System.out.println("Enter club location : ");
                String clubLocation = scanner1.next();
                System.out.println("Enter number of wins : ");
                int wins = scanner1.nextInt();
                System.out.println("Enter number of defeats : ");
                int defeats = scanner1.nextInt();
                System.out.println("Enter number of draws : ");
                int draws = scanner1.nextInt();
                System.out.println("Enter number of goals received : ");
                int goalReceived = scanner1.nextInt();
                System.out.println("Enter number of goals scored : ");
                int goalScored = scanner1.nextInt();

                FootballClub newFbClub = new FootballClub(clubName,clubLocation,wins,defeats,draws,goalReceived,goalScored);
                premierLeagueManager.addFootballClub(newFbClub);
                System.out.println(premierLeagueManager.footballClubList);

            } else if (type == 2){

                System.out.println("Enter the university name: ");
                String universityName = scanner1.next();
                System.out.println("Enter Club name : ");
                String clubName = scanner1.next();
                System.out.println("Enter club location : ");
                String clubLocation = scanner1.next();
                System.out.println("Enter number of points : ");
                int wins = scanner1.nextInt();
                System.out.println("Enter number of defeats : ");
                int defeats = scanner1.nextInt();
                System.out.println("Enter number of draws : ");
                int draws = scanner1.nextInt();
                System.out.println("Enter number of goals received : ");
                int goalReceived = scanner1.nextInt();
                System.out.println("Enter number of goals scored : ");
                int goalScored = scanner1.nextInt();

                FootballUniversityClub footballUniversityClub = new FootballUniversityClub(clubName,clubLocation,wins,defeats,draws,goalReceived,goalScored,universityName);
                premierLeagueManager.addFootballClub(footballUniversityClub);
                System.out.println(premierLeagueManager.footballClubList);

            } else if (type == 3){

                System.out.println("Enter the school name: ");
                String schoolName = scanner1.next();
                System.out.println("Enter Club name : ");
                String clubName = scanner1.nextLine();
                System.out.println("Enter club location : ");
                String clubLocation = scanner1.next();
                System.out.println("Enter number of wins : ");
                int wins = scanner1.nextInt();
                System.out.println("Enter number of defeats : ");
                int defeats = scanner1.nextInt();
                System.out.println("Enter number of draws : ");
                int draws = scanner1.nextInt();
                System.out.println("Enter number of goals received : ");
                int goalReceived = scanner1.nextInt();
                System.out.println("Enter number of goals scored : ");
                int goalScored = scanner1.nextInt();

                FootballSchoolClub footballSchoolClub = new FootballSchoolClub(clubName,clubLocation,wins,defeats,draws,goalReceived,goalScored,schoolName);
                premierLeagueManager.addFootballClub(footballSchoolClub);
                System.out.println(premierLeagueManager.footballClubList);

            } else {

                System.out.println("Invalid input!!");

            }
        }catch (InputMismatchException exception2){

            System.out.println("Invalid Input!! try again..");

        }



    }

    public static void remove(){

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter club name to remove : ");
        String clubName = scanner2.next();
        premierLeagueManager.deleteFootballClub(clubName);
        System.out.println(premierLeagueManager.footballClubList);

    }

    public static void displayStatics(){

        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Enter club name to display its statics: ");
        String clubName = scanner3.next();
        premierLeagueManager.displayStatics(clubName);

    }

    public static void premierLeagueTable(){
        premierLeagueManager.displayTable();
    }

    public static void addAPlayedMatch() {

        try {
            Scanner scanner4 = new Scanner(System.in);
            System.out.println("Enter the team 1: ");
            String team1 = scanner4.next();
            System.out.println("Enter the team 2: ");
            String team2 = scanner4.next();
            System.out.print("Enter team 1 goals: ");
            int goals1 = scanner4.nextInt();
            System.out.print("Enter team 2 goals : ");
            int goals2 = scanner4.nextInt();
            System.out.println("Enter the date!!!!!");
            System.out.print("Enter the day : ");
            int day = scanner4.nextInt();
            System.out.print("Enter the month : ");
            int month = scanner4.nextInt();
            System.out.print("Enter the year : ");
            int year = scanner4.nextInt();

            Date date = new Date(day,month,year);
            Match match = new Match(team1,team2,goals1,goals2,date);
            premierLeagueManager.addAPlayedMatch(match);
            System.out.println(premierLeagueManager.matchList);

        }catch (InputMismatchException exception3){

            System.out.println("Invalid Input!! Try Again..");

        }


    }

    public static void fileWrite() throws IOException {

        premierLeagueManager.writeClubStatics("ClubStatics.txt");
        premierLeagueManager.writeMatchStatics("MatchStatics.txt");

    }

    public static void readFile() throws IOException, ClassNotFoundException {

        premierLeagueManager.readClubStatics("ClubStatics.txt");
        premierLeagueManager.readMatchStatics("MatchStatics.txt");

    }



}
