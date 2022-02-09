package pl.javaskills.creditapp.core.model;

public enum MaritalStatus {
    SINGLE,
    MARRIED(100),
    DIVORCED,
    SEPARATED(100),
    WIDOWED;

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