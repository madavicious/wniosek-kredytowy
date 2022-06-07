package pl.javaskills.creditapp.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.javaskills.creditapp.core.annotation.NotNull;

import java.io.Serializable;

public class SourceOfIncome implements Serializable {
    public static final long serialVersionUID = 1l;
    @NotNull
    @JsonProperty
    private IncomeType incomeType;
    @JsonProperty
    private double netMonthlyIncome;

    public SourceOfIncome(){}

    public SourceOfIncome(IncomeType incomeType, double netMonthlyIncome) {
        this.incomeType = incomeType;
        this.netMonthlyIncome = netMonthlyIncome;
    }

    public IncomeType getIncomeType() {
        return incomeType;
    }

    public double getNetMonthlyIncome() {
        return netMonthlyIncome;
    }
}
