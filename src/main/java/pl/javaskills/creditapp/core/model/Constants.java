package pl.javaskills.creditapp.core.model;

public interface Constants {
    double MORTGAGE_LOAN_RATE = 0.2;
    double PERSONAL_LOAN_LOAN_RATE = 0.1;
    String DOUBLE_REGEX = "(\\d+)(\\.\\d+)?";
    String INTEGER_REGEX = "[0-9]+";
    String NAME_REGEX = "[A-ZĄ-Ź][a-zą-ź]{2,9}";
    String LAST_NAME_REGEX = "([A-ZĄ-Ź][a-zą-ź]+)([\\s-]([A-ZĄ-Ź][a-zą-ź]+))?";
    String EMAIL_REGEX = ".+@.+";
    String PHONE_REGEX = "(\\+\\d{2})?\\d{9}";
    double MIN_LOAN_AMOUNT_MORTGAGE = 100000.00;
}
