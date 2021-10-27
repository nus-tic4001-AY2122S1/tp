package seedu.duke;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parser {
    public static int index(String index) {
        return Integer.parseInt(index) - 1;
    }

    public static double amount(String amount) {
        return Double.parseDouble(amount);
    }

    public static Date date(String date) throws InputErrorException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

        try {
            return formatter.parse(date);
        } catch (ParseException p) {
            throw new InputErrorException("DateFormatError");
        }
    }
}
