package seedu.duke;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parser {
    public static int index(String index) throws InputErrorException {
        try {
            return Integer.parseInt(index) - 1;
        } catch (NumberFormatException e) {
            throw new InputErrorException("IndexNotInt");
        }
    }

    public static double amount(String amount) throws InputErrorException {
        try {
            return Double.parseDouble(amount);
        } catch (NumberFormatException e) {
            throw new InputErrorException("AmountNotNumber");
        }
    }

    public static Date date(String date) throws InputErrorException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        try {
            return formatter.parse(date);
        } catch (ParseException p) {
            throw new InputErrorException("DateFormatError");
        }
    }
}
