package pl.javaskills.creditapp.core.model;

import pl.javaskills.creditapp.core.CreditApplicationDecision;

import java.io.Serializable;

public class ProcessedCreditApplication implements Serializable {
    public static final long serialVersionUID = 1l;
    private final LoanApplication application;
    private final CreditApplicationDecision decision;

    public ProcessedCreditApplication(LoanApplication creditApplication, CreditApplicationDecision creditApplicationDecision) {
        this.application = creditApplication;
        this.decision = creditApplicationDecision;
    }

    public LoanApplication getApplication() {
        return application;
    }

    public CreditApplicationDecision getDecision() {
        return decision;
    }


}
