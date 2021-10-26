package seedu.duke;

import seedu.duke.item.Expense;
import seedu.duke.item.Income;
import seedu.duke.item.Item;

import java.util.ArrayList;
import java.util.Date;

public class itemList {
    public ArrayList<Item> items;
    public int size;

    public itemList(ArrayList<Item> items) {
        this.items = items;
        this.size = items.size();
    }

    public void addExpense(String description, String category, double amount, Date date) {
        Expense expense = new Expense(description, category, amount, date, "expense");
        items.add(expense);
        size++;
    }


    public void addIncome(String description, String category, double amount, Date date) {
        Income income = new Income(description, category, amount, date, "income");
        items.add(income);
        size++;
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
}
