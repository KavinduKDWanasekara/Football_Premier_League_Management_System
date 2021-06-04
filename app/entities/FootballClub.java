package entities;

import java.io.Serializable;
import java.util.Objects;

public class FootballClub extends SportClub implements Serializable,Comparable<FootballClub>  {
    private int ToPoints;
    private int numOfWins;
    private int numOfDefeats;
    private int numOfDraws;
    private int numOfGoalsReceived;
    private int numOfGoalsScored;
    private int numberOfMatches;

    public FootballClub(String clubName, String location, int numOfWins, int numOfDefeats, int numOfDraws, int numOfGoalsReceived, int numOfGoalsScored) {
        super(clubName, location);
        this.numOfWins = numOfWins;
        this.numOfDefeats = numOfDefeats;
        this.numOfDraws = numOfDraws;
        this.numOfGoalsReceived = numOfGoalsReceived;
        this.numOfGoalsScored = numOfGoalsScored;
    }

    public int getGoalDifference(){
        return numOfGoalsScored-numOfGoalsReceived;
    }
    public int getNumOfWins() {
        return numOfWins;
    }

    public void setNumOfWins(int numOfWins) {
        this.numOfWins = numOfWins;
    }

    public int getNumOfDraws() {
        return numOfDraws;
    }

    public void setNumOfDraws(int numOfDraws) {
        this.numOfDraws = numOfDraws;
    }

    public int getNumOfDefeats() {
        return numOfDefeats;
    }

    public void setNumOfDefeats(int numOfDefeats) {
        this.numOfDefeats = numOfDefeats;
    }

    public int getNumOfGoalsReceived() {
        return numOfGoalsReceived;
    }

    public void setNumOfGoalsReceived(int numOfGoalsReceived) {
        this.numOfGoalsReceived = numOfGoalsReceived;
    }

    public int getNumOfGoalsScored() {
        return numOfGoalsScored;
    }

    public void setNumOfGoalsScored(int numOfGoalsScored) {
        this.numOfGoalsScored = numOfGoalsScored;
    }

    public int getToPoints() {
        return ToPoints= getNumOfWins()*3+getNumOfDraws();
    }

    public void setToPoints(int toPoints) {
        ToPoints = toPoints;
    }

    public int getNumberOfMatches() {
        return numberOfMatches= getNumOfWins()+getNumOfDefeats()+getNumOfDraws();
    }

    public void setNumberOfMatches(int numberOfMatches) {
        this.numberOfMatches = numberOfMatches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FootballClub that = (FootballClub) o;
        return numOfWins == that.numOfWins &&
                numOfDraws == that.numOfDraws &&
                numOfDefeats == that.numOfDefeats &&
                numOfGoalsReceived == that.numOfGoalsReceived &&
                numOfGoalsScored == that.numOfGoalsScored &&
                ToPoints == that.ToPoints &&
                numberOfMatches == that.numberOfMatches;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numOfWins, numOfDraws, numOfDefeats, numOfGoalsReceived, numOfGoalsScored, ToPoints, numberOfMatches);
    }

    @Override
    public String toString() {
        return "clubName=" + getClubName()+
                ", location=" + getLocation()+
                ", numOfWins=" + numOfWins +
                ", numOfDefeats=" + numOfDefeats +
                ", numOfDraws=" + numOfDraws +
                ", numOfGoalsReceived=" + numOfGoalsReceived +
                ", numOfGoalsScored=" + numOfGoalsScored
                ;
    }

    @Override
    public int compareTo(FootballClub o) {
        if (this.getToPoints()!=o.getToPoints()){
            if (this.getToPoints()>o.getToPoints()){
                return -1;
            }
            else {
                return 1;
            }
        }
        else {
            if (this.getGoalDifference()>this.getGoalDifference()){
                return -1;
            }
            else {
                return 1;
            }
        }
    }
}
