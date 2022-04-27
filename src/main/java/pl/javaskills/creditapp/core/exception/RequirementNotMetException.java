package pl.javaskills.creditapp.core.exception;

public class RequirementNotMetException extends Exception{
    private final RequirementNotMetCause requirementNotMetCause;


    public RequirementNotMetException(RequirementNotMetCause requirementNotMetCause) {
        this.requirementNotMetCause = requirementNotMetCause;
    }

    public RequirementNotMetCause getRequirementNotMetCause() {
        return requirementNotMetCause;
    }
}
