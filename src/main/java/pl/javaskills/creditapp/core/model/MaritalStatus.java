package pl.javaskills.creditapp.core.model;

public enum MaritalStatus {
    DIVORCED,
    SEPARATED(100),
    SINGLE,
    WIDOWED,
    MARRIED(100);

    private int scoringPoints;

    MaritalStatus() {
        this.scoringPoints = 0;
    }

    MaritalStatus(int scoringPoints) {
        this.scoringPoints = scoringPoints;
    }

    public int getScoringPoints() {
        return scoringPoints;
    }
}
