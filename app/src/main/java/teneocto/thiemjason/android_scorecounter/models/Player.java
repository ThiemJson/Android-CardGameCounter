package teneocto.thiemjason.android_scorecounter.models;

public class Player {
    private String name;
    private Integer score;
    private Boolean isClicked;

    public Player(String name, Integer score) {
        this.name = name;
        this.score = score;
        this.isClicked = false;
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Boolean getClicked() {
        return isClicked;
    }

    public void setClicked(Boolean clicked) {
        isClicked = clicked;
    }
}
