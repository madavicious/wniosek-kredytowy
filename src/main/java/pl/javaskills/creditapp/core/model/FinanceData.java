package pl.javaskills.creditapp.core.model;

import java.util.Arrays;
import java.util.List;

public class FinanceData {
    private final List<SourceOfIncome> sourcesOfIncome;

    public FinanceData(SourceOfIncome... sourcesOfIncome) {
        this.sourcesOfIncome = Arrays.asList(sourcesOfIncome);
    }

    public List<SourceOfIncome> getSourcesOfIncome() {
        return sourcesOfIncome;
    }
}
