package pl.javaskills.creditapp.core.model;

public enum Education {
    PRIMARY(-100),
    MIDDLE,
    SECONDARY,
    POST_SECONDARY,
    TERTIARY(100),
    NONE(-200);

    private int scoringPoints;

    Education() {
        this.scoringPoints = 0;
    }

    Education(int scoringPoints) {
        this.scoringPoints = scoringPoints;
    }

    public int getScoringPoints() {
        return scoringPoints;
    }
}
