package seedu.duke.expense;

import java.util.Date;

public class Expense {
    Date date;
    String description;
    double amount;

    public Expense(Date date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public String toString() {
        return "[" + date + "] " + description + " ($" + amount + ")";
    }
}
