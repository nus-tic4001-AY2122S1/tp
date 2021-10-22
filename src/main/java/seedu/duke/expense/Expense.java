package seedu.duke.expense;

import java.text.SimpleDateFormat;
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MMM.dd");

        return "[" + sdf.format(date) + "] " + description + " ($" + amount + ")";
    }
}
