package pl.javaskills.creditapp.core.model;

import pl.javaskills.creditapp.core.annotation.NotNull;

import java.util.Objects;

public class Expense {

    @NotNull
    private final String name;

    @NotNull
    private final ExpenseType type;
    private final double amount;

    public Expense(String name, ExpenseType type, double amount) {
        this.name = name;
        this.type = type;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return name.equals(expense.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public ExpenseType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}
