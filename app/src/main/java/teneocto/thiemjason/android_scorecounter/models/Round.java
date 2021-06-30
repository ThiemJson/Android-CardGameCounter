package teneocto.thiemjason.android_scorecounter.models;

import java.util.ArrayList;

public class Round {
    private Integer coefficient;
    private ArrayList<Player> players;

    public Round(Integer coefficient, ArrayList<Player> players) {
        this.coefficient = coefficient;
        this.players = players;
    }

    public Integer getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
