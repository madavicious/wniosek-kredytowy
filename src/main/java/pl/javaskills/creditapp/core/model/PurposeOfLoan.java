package pl.javaskills.creditapp.core.model;

import pl.javaskills.creditapp.core.annotation.NotNull;

public class PurposeOfLoan {

    @NotNull
    private final PurposeOfLoanType purposeOfLoanType;
    private final double amount;
    private final int period;

    public PurposeOfLoan(PurposeOfLoanType purposeOfLoanType, double amount, int period) {
        this.purposeOfLoanType = purposeOfLoanType;
        this.amount = amount;
        this.period = period;
    }

    public PurposeOfLoanType getPurposeOfLoanType() {
        return purposeOfLoanType;
    }

    public double getAmount() {
        return amount;
    }

    public int getPeriod() {
        return period;
    }
}
