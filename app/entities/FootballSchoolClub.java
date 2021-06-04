package entities;

import java.io.Serializable;
import java.util.Objects;

public class FootballSchoolClub extends FootballClub implements Serializable {
    private String sclName;

    public FootballSchoolClub(String clubName, String location, int numOfWins, int numOfDraws, int numOfDefeats, int numOfGoalsReceived, int numOfGoalsScored, String sclName) {
        super(clubName, location,numOfWins, numOfDraws, numOfDefeats, numOfGoalsReceived, numOfGoalsScored);
        this.sclName = sclName;
    }

    public String getSclName() {
        return sclName;
    }

    public void setSclName(String sclName) {
        this.sclName = sclName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FootballSchoolClub that = (FootballSchoolClub) o;
        return Objects.equals(sclName, that.sclName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sclName);
    }

    @Override
    public String toString() {
        return "FootballSchoolClub{" +
                "sclName='" + sclName +
                "clubName=" + getClubName()+
                ", location=" + getLocation()+
                ", numOfWins=" + getNumOfWins() +
                ", numOfDefeats=" + getNumOfDefeats() +
                ", numOfDraws=" + getNumOfDraws() +
                ", numOfGoalsReceived=" + getNumOfGoalsReceived() +
                ", numOfGoalsScored=" + getNumOfGoalsScored() +'\'' +
                '}';
    }
}


