package seedu.duke.expense;

public class Expense {
    String date;
    String description;
    double amount;

    public Expense(String date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public String toString() {
        return "[" + date + "] " + description + " ($" + amount + ")";
    }
}
