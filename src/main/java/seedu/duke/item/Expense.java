package seedu.duke.item;

import java.util.Date;

public class Expense extends Item {
    private String type;

    public Expense(String description, String category, double amount, Date date, String type) {
        super(description, category, amount, date, type);
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "[E] " + super.toString();
    }

    @Override
    public String save_toString() {
        return "E | " + super.save_toString();
    }
}
