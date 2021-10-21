package seedu.duke;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parser {
    public static String command(String fullCommand) {
        return fullCommand.split(" ")[0].toLowerCase();
    }

    public static int index(String fullCommand) {
        String buffer = fullCommand.split(" ")[1];

        //assert (!buffer.matches("\\d+")) : "Index must be Integer!";
        return Integer.parseInt(fullCommand.split(" ")[1]) - 1;
    }

    public static String description(String fullCommand) {
        String[] s1 = fullCommand.split(" ");
        String[] s2 = fullCommand.split(" /");
        return s2[0].replace(s1[0] + " ", "");
    }

    public static Date date(String fullCommand) throws InputErrorException {
        String[] s1 = fullCommand.split(" /SGD");
        String[] s2 = s1[0].split(" /");
        return convertStrToDate(s2[1]);
    }

    public static double amount(String fullCommand) {
        return Double.parseDouble(fullCommand.split(" /SGD")[1]);
    }

    private static Date convertStrToDate(String date) throws InputErrorException {

        SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy");

        try{
            return formatter.parse(date);
        } catch (ParseException p) {
            throw new InputErrorException("DateFormatError");
        }
    }
}
