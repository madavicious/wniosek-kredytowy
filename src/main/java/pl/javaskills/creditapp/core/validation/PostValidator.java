package pl.javaskills.creditapp.core.validation;

import pl.javaskills.creditapp.core.exception.RequirementNotMetException;
import pl.javaskills.creditapp.core.model.LoanApplication;

public interface PostValidator {

    void validate(LoanApplication creditApplication, int scoring, double rating) throws RequirementNotMetException;

}
