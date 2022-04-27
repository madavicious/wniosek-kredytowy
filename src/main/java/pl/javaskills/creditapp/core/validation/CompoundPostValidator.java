package pl.javaskills.creditapp.core.validation;

import pl.javaskills.creditapp.core.exception.RequirementNotMetException;
import pl.javaskills.creditapp.core.model.LoanApplication;

public class CompoundPostValidator implements PostValidator{
    private final PostValidator[] postValidators;

    public CompoundPostValidator(PostValidator... postValidators) {
        this.postValidators = postValidators;
    }

    @Override
    public void validate(LoanApplication loanApplication, int scoring, double rating) throws RequirementNotMetException {
        for(PostValidator postValidator : postValidators){
            postValidator.validate(loanApplication, scoring, rating);
        }
    }
}
