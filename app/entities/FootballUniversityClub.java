package entities;

import java.io.Serializable;
import java.util.Objects;

public class FootballUniversityClub extends FootballClub implements Serializable {
    private String uniName;

    public FootballUniversityClub(String clubName, String location, int numOfWins, int numOfDraws, int numOfDefeats, int numOfGoalsReceived, int numOfGoalsScored, String uniName) {
        super(clubName, location, numOfWins, numOfDraws, numOfDefeats, numOfGoalsReceived, numOfGoalsScored);
        this.uniName = uniName;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FootballUniversityClub that = (FootballUniversityClub) o;
        return Objects.equals(uniName, that.uniName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), uniName);
    }

    @Override
    public String toString() {
        return "FootballUniversityClub{" +
                "uniName='" + uniName +
                "clubName=" + getClubName()+
                ", location=" + getLocation()+
                ", numOfWins=" + getNumOfWins() +
                ", numOfDefeats=" + getNumOfDefeats() +
                ", numOfDraws=" + getNumOfDraws() +
                ", numOfGoalsReceived=" + getNumOfGoalsReceived() +
                ", numOfGoalsScored=" + getNumOfGoalsScored() + '\'' +
                '}';
    }
}



