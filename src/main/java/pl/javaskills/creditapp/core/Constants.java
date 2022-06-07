package pl.javaskills.creditapp.core;

import java.time.ZoneId;
import java.util.Locale;

public interface Constants {
    double MORTGAGE_LOAN_RATE = 0.2;
    double PERSONAL_LOAN_LOAN_RATE = 0.1;
    String DOUBLE_REGEX = "(\\d+)(\\.\\d+)?";
    String INTEGER_REGEX = "[0-9]+";
    String NAME_REGEX = "[A-ZĄ-Ź][a-zą-ź]{2,9}";
    String LAST_NAME_REGEX = "([A-ZĄ-Ź][a-zą-ź]+)([\\s-]([A-ZĄ-Ź][a-zą-ź]+))?";
    String EMAIL_REGEX = ".+@.+";
    String PHONE_REGEX = "(\\+\\d{2})?\\d{9}";
    String PESEL_REGEX = "\\d{11}";
    double MIN_LOAN_AMOUNT_MORTGAGE = 100000.00;
    ZoneId DEFAULT_SYSTEM_ZONE_ID = ZoneId.of("America/New_York");
    Locale DEFAULT_LOCALE = Locale.US;
    String BIK_API_URL_ENDPOINT = "https://test-api.javaskills.pl/udemy/bik/scoring";
    String OUTPUT_PATH = "/tmp/java17/";
}
