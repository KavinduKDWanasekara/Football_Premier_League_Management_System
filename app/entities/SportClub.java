package entities;

import java.io.Serializable;
import java.util.Objects;

public class SportClub implements Serializable {
    private String clubName;
    private String location;

    public SportClub(String clubName, String location) {
        this.clubName = clubName;
        this.location = location;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportClub sportClub = (SportClub) o;
        return clubName.equals(sportClub.clubName) &&
                location.equals(sportClub.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clubName, location);
    }
}


