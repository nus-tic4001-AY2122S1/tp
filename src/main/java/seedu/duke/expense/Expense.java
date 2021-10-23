package seedu.duke.expense;

//<<<<<<< master
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Timestamp;

public class Expense {
    private Date date;
    private String description;
    private double amount;
    private Timestamp recordDateTime;

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public Expense(Date date, String description, double amount,  Timestamp recordDateTime) {
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.recordDateTime = recordDateTime;
    }

    public String toString() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MMM.dd");

        return "[" + sdf.format(date) + "] " + description + " ($" + amount + " (System datetime:" + recordDateTime + ")";
    }
}
