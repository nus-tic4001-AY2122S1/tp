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
    private String category;

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

    public Expense(Date date, String description, double amount,  Timestamp recordDateTime, String category) {
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.recordDateTime = recordDateTime;
        this.category = category;
    }

    public String getCategory() {
        return this.category;
    }

    public String toString() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
        String dateInfo = "[" + sdf.format(date) + "] ";
        String des = description;
        String amountInfo = " ($" + amount + ")";
        String sysDatetime = " (System datetime: " + recordDateTime + ")";
        return dateInfo + des + amountInfo + sysDatetime;
    }
}
