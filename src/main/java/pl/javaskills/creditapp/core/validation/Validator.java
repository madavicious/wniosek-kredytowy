package pl.javaskills.creditapp.core.validation;

import pl.javaskills.creditapp.core.exception.ValidationException;
import pl.javaskills.creditapp.core.model.LoanApplication;

public interface Validator {
    void validate(LoanApplication creditApplication) throws ValidationException;
}
