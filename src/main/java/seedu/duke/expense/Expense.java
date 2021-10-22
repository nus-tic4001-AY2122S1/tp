package seedu.duke.expense;

//<<<<<<< master
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Timestamp;

public class Expense {
    Date date;
//=======
//import java.sql.Timestamp;

//public class Expense {

//    String date;
//>>>>>>> master
    String description;
    double amount;
    Timestamp recordDateTime;

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

//<<<<<<< master
    public Expense(Date date, String description, double amount,  Timestamp recordDateTime) {
//=======
//  public Expense(String date, String description, double amount, Timestamp recordDateTime) {
//>>>>>>> master
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.recordDateTime = recordDateTime;
    }

    public String toString() {
//<<<<<<< master
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MMM.dd");

        return "[" + sdf.format(date) + "] " + description + " ($" + amount + " (System datetime:" + recordDateTime + ")";
//=======
//        return "[" + date + "] " + description + " ($" + amount + ")" + " (System datetime:" + recordDateTime + ")";
//>>>>>>> master
    }
}
