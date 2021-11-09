package seedu.duke;

import seedu.duke.item.Expense;
import seedu.duke.item.Income;
import seedu.duke.item.Item;

import java.util.ArrayList;
import java.util.Date;

public class ItemList {
    public ArrayList<Item> items;
    public int size;
    private double incomeAmount = 0.0;
    private double expenseAmount = 0.0;
    private Date earliestDate = null;
    private Date latestDate = null;


    public ItemList(ArrayList<Item> items) {
        this.items = items;
        this.size = items.size();
    }

    public void addExpense(String description, String category, double amount, Date date) {
        Expense expense = new Expense(description, category, amount, date, "expense");
        items.add(expense);
        size++;
        expenseAmount += amount;
        addEarliestDate(date);
        addLatestDate(date);
    }

    public void addIncome(String description, String category, double amount, Date date) {
        Income income = new Income(description, category, amount, date, "income");
        items.add(income);
        size++;
        incomeAmount += amount;
        addEarliestDate(date);
        addLatestDate(date);
    }

    private void addEarliestDate(Date addedDate) {
        if (earliestDate == null) {
            earliestDate = addedDate;
        } else if (earliestDate.after(addedDate)) {
            earliestDate = addedDate;
        }
    }

    private void addLatestDate(Date addedDate) {
        if (latestDate == null) {
            latestDate = addedDate;
        } else if (latestDate.before(addedDate)) {
            latestDate = addedDate;
        }
    }

    public void find(String keyword, ArrayList<Integer> findResult) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).toString().contains(keyword)) {
                findResult.add(i);
            }
        }
    }

    public void delete(int index) {
        items.remove(index);
        size--;
    }

    public void edit(int index, Item newItem) {
        items.set(index, newItem);
    }

    /**
     * The function to get overall income amount
     * @return double type, overall income amount
     */
    public double getIncomeAmount() {
        return incomeAmount;
    }

    /**
     * The function to return total expense amount
     * @return double type, total expense amount
     */
    public double getExpenseAmount() {
        return expenseAmount;
    }

    /**
     * The function to return the first date to use this system
     * @return Date type first date
     */
    public Date getEarliestDate() {
        return earliestDate;
    }

    /**
     * The function to return the date of adding last item
     * @return Date type, the date of adding last item
     */
    public Date getLatestDate() {
        return latestDate;
    }
}
