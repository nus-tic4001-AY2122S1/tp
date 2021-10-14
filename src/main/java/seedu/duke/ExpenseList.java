package seedu.duke;

import seedu.duke.expense.Expense;

import java.util.ArrayList;

public class ExpenseList {
    public ArrayList<Expense> expenses;
    public int size;

    public ExpenseList(ArrayList<Expense> expenses) {
        this.expenses = expenses;
        this.size = expenses.size();
    }

    public void addExpense(String date, String description, double amount) {
        Expense expense = new Expense(date, description, amount);
        expenses.add(expense);
        size++;
    }

    public void delete(int index) {
        expenses.remove(index);
        size--;
    }
}
