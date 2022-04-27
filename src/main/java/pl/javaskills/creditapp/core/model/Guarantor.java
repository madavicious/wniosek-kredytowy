package pl.javaskills.creditapp.core.model;

import org.jetbrains.annotations.NotNull;
import pl.javaskills.creditapp.core.annotation.Regex;

import java.util.Objects;

public class Guarantor implements Comparable<Guarantor>{

    @NotNull
    @Regex(Constants.PESEL_REGEX)
    private final String pesel;

    @NotNull
    private final Integer age;

    public Guarantor(String pesel, Integer age) {
        this.pesel = pesel;
        this.age = age;
    }

    public String getPesel() {
        return pesel;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public int compareTo(@NotNull Guarantor g) {
        if(g.pesel.compareTo(this.pesel) != 0) {
            return g.pesel.compareTo(this.pesel);
        }
        return this.age.compareTo(g.age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guarantor guarantor = (Guarantor) o;
        return pesel.equals(guarantor.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pesel);
    }

    public static class Builder{
        private String pesel;
        private Integer age;

        private Builder(){}
        public static Builder create(){
            return new Builder();
        }

        public Builder withPesel(String pesel){
            this.pesel = pesel;
            return this;
        }

        public Builder withAge(int age){
            this.age = age;
            return this;
        }

        public Guarantor build(){
            return new Guarantor(pesel, age);
        }

    }
}
