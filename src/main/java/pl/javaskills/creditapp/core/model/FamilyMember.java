package pl.javaskills.creditapp.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import pl.javaskills.creditapp.core.Constants;
import pl.javaskills.creditapp.core.annotation.Regex;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class FamilyMember implements Comparable<FamilyMember>, Serializable {
    public static final long serialVersionUID = 1l;

    @NotNull
    @Regex(Constants.NAME_REGEX)
    @JsonProperty
    private String name;

    @NotNull
    @JsonProperty
    private LocalDate birthDate;

    public FamilyMember(){}

    public FamilyMember(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    @Override
    public int compareTo(@NotNull FamilyMember o) {
        return o.birthDate.compareTo(birthDate);
    }

    @Override
    public String toString() {
        return "FamilyMember [birth date=" + birthDate + ", name=" + name + "]";
    }

    
}
