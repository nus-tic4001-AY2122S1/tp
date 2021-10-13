package expense;

import java.util.Date;

public class Expense {
    int amount;
    Date date;
    String description;

    Expense(int amount, Date date, String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
    }
}
