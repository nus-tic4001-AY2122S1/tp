package seedu.duke.item;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Item {
    private Date date;
    private String description;
    private double amount;
    private String category;
    private String type;

    public Item(String description, String category, double amount, Date date, String type) {
        this.description = description;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getDescription() {
        return this.description;
    }

    public Date getDate() {
        return this.date;
    }

    public String getCategory() {
        return this.category;
    }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
        String dateInfo = "(" + sdf.format(date) + ")";
        return "[" + category + "] " + description + " ($" + amount + ") " + dateInfo;
    }
}
