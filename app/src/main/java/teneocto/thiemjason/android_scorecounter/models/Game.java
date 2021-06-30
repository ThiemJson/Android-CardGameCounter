package teneocto.thiemjason.android_scorecounter.models;

import java.util.ArrayList;
import java.util.Date;

public class Game {
    private ArrayList<Player> players;
    private Date createdDate;
    private ArrayList<Round> rounds;
    private Integer maxScore;
    private Integer maxPlayer;

    public Game(ArrayList<Player> players, Date createdDate, ArrayList<Round> rounds) {
        this.players = players;
        this.createdDate = createdDate;
        this.rounds = rounds;
    }

    public Game(ArrayList<Player> players, Date createdDate, ArrayList<Round> rounds, Integer maxScore, Integer maxPlayer) {
        this.players = players;
        this.createdDate = createdDate;
        this.rounds = rounds;
        this.maxScore = maxScore;
        this.maxPlayer = maxPlayer;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }

    public Integer getMaxPlayer() {
        return maxPlayer;
    }

    public void setMaxPlayer(Integer maxPlayer) {
        this.maxPlayer = maxPlayer;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public ArrayList<Round> getRounds() {
        return rounds;
    }

    public void setRounds(ArrayList<Round> rounds) {
        this.rounds = rounds;
    }
}
