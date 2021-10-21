package seedu.duke;

import seedu.duke.expense.Expense;

import java.sql.Timestamp;
import java.util.ArrayList;

public class ExpenseList {
    public ArrayList<Expense> expenses;
    public int size;

    public ExpenseList(ArrayList<Expense> expenses) {
        this.expenses = expenses;
        this.size = expenses.size();
    }

    public void addExpense(String date, String description, double amount, Timestamp recordDateTime) {
        Expense expense = new Expense(date, description, amount, recordDateTime);
        expenses.add(expense);
        size++;
    }

    public void addIncome(String date, String description, double amount, Timestamp recordDateTime) {
        Expense income = new Expense(date, description, amount, recordDateTime);
        expenses.add(income);
        size++;
    }

    public void delete(int index) {
        expenses.remove(index);
        size--;
    }
}
