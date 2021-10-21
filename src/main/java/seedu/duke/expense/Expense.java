package seedu.duke.expense;

import java.sql.Timestamp;

public class Expense {
    String date;
    String description;
    double amount;
    Timestamp recordDateTime;

    public Expense(String date, String description, double amount, Timestamp recordDateTime) {
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.recordDateTime = recordDateTime;
    }

    public String toString() {
        return "[" + date + "] " + description + " ($" + amount + ")" + " (System datetime:" + recordDateTime + ")";
    }
}
