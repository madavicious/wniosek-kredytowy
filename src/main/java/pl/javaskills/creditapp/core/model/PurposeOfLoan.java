package pl.javaskills.creditapp.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.javaskills.creditapp.core.annotation.NotNull;

import java.io.Serializable;

public class PurposeOfLoan implements Serializable {
    public static final long serialVersionUID = 1l;
    @NotNull
    @JsonProperty
    private PurposeOfLoanType purposeOfLoanType;
    @JsonProperty
    private double amount;
    @JsonProperty
    private int period;

    public PurposeOfLoan(){}

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
