package seedu.duke;

import seedu.duke.expense.Expense;

import java.util.ArrayList;
import java.util.Date;

public class ExpenseList {
    public ArrayList<Expense> expenses;
    public int size;

    public ExpenseList(ArrayList<Expense> expenses) {
        this.expenses = expenses;
        this.size = expenses.size();
    }

    public void addExpense(Date date, String description, double amount) {
        Expense expense = new Expense(date, description, amount);
        expenses.add(expense);
        size++;
    }

    public void delete(int index) {
        expenses.remove(index);
        size--;
    }
}
