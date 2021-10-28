package seedu.duke.item;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Item {
    private Date date;
    private String description;
    private double amount;
    private String category;

    public double getAmount() {
        return amount;
    }

    public Item(String description, String category, double amount, Date date) {
        this.description = description;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
        String dateInfo = "(" + sdf.format(date) + ")";
        return "[" + category + "] " + description + " ($" + amount + ") " + dateInfo;
    }
}
