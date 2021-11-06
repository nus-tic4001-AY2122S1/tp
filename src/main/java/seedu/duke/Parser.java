package seedu.duke;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parser {
    // expense lunch /food /date /amount

    public static String command(String fullCommand) {
        return fullCommand.split(" ")[0].toLowerCase();
    }

    public static int index(String fullCommand) throws InputErrorException {
        try {
            return Integer.parseInt(fullCommand.split(" ")[1]) - 1;
        } catch (NumberFormatException e) {
            throw new InputErrorException("IndexNotInt");
        }
    }

    public static String description(String fullCommand) {
        String[] s1 = fullCommand.split(" ");
        String[] s2 = fullCommand.split(" /");
        return s2[0].replace(s1[0] + " ", "");
    }

    public static String category(String fullCommand) throws InputErrorException {
        String[] str = fullCommand.split(" /");

        if (str.length != 4) {
            throw new InputErrorException("InputInfoShortage");
        }

        return fullCommand.split(" /")[1];
    }

    public static double amount(String fullCommand) throws InputErrorException {
        try {
            return Double.parseDouble(fullCommand.split(" /")[2]);
        } catch (NumberFormatException e) {
            throw new InputErrorException("AmountNotNumber");
        }
    }

    public static Date date(String fullCommand) throws InputErrorException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        try {
            return formatter.parse(fullCommand.split(" /")[3]);
        } catch (ParseException p) {
            throw new InputErrorException("DateFormatError");
        }
    }

    public static String[] sortDesc(String fullCommand) throws InputErrorException {

        String[] str = fullCommand.split(" /");

        if (str.length < 3) {
            throw new InputErrorException("SortFormatError");
        }
        return fullCommand.split(" /");
    }

}
