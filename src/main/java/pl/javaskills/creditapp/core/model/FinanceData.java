package pl.javaskills.creditapp.core.model;

import pl.javaskills.creditapp.core.annotation.NotNull;
import pl.javaskills.creditapp.core.annotation.ValidateCollection;

import java.util.*;

public class FinanceData {

    @NotNull
    @ValidateCollection
    private final List<SourceOfIncome> sourcesOfIncome;

    @NotNull
    @ValidateCollection
    private final Set<Expense> expenses;

    public FinanceData(SourceOfIncome... sourcesOfIncome) {
        this.sourcesOfIncome = Arrays.asList(sourcesOfIncome);
        this.expenses = new HashSet<>();
    }

    public FinanceData(Set<Expense> expenses, SourceOfIncome... sourcesOfIncome) {
        this.sourcesOfIncome = Arrays.asList(sourcesOfIncome);
        this.expenses = expenses;
    }

    private Map<ExpenseType, Set<Expense>> getExpensesMap(){
        Map<ExpenseType, Set<Expense>> result = new HashMap<>();
        for (Expense expense : expenses) {
            if(result.containsKey(expense.getType())){
                result.get(expense.getType()).add(expense);
            } else{
                Set<Expense> set = new HashSet<>();
                set.add(expense);
                result.put(expense.getType(), set);
            }
        }
        return result;
    }

    public Set<Expense> getExpenses() {
        return expenses;
    }

    public double getSumOfExpenses(ExpenseType type){
        double sum = 0.0;
        Map<ExpenseType, Set<Expense>> expenseTypeSetMap = getExpensesMap();
        if (expenseTypeSetMap.isEmpty()){
            return sum;
        }
        for (Expense expense : expenseTypeSetMap.get(type)){
            sum += expense.getAmount();
        }
        return sum;
    }

    public List<SourceOfIncome> getSourcesOfIncome() {
        return sourcesOfIncome;
    }
}
