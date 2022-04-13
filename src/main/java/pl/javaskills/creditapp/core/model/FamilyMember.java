package pl.javaskills.creditapp.core.model;

import org.jetbrains.annotations.NotNull;

public class FamilyMember implements Comparable<FamilyMember>{
    private final String name;
    private final Integer age;

    public FamilyMember(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public int compareTo(@NotNull FamilyMember o) {
        return o.age.compareTo(age);
    }

    @Override
    public String toString() {
        return "FamilyMember [age=" + age + ", name=" + name + "]";
    }

    
}
