package seedu.duke;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parser {
    public static String command(String fullCommand) {
        return fullCommand.split(" ")[0].toLowerCase();
    }

    public static int index(String fullCommand) {
        //String buffer = fullCommand.split(" ")[1];

        //assert (!buffer.matches("\\d+")) : "Index must be Integer!";
        return Integer.parseInt(fullCommand.split(" ")[1]) - 1;
    }

    public static String description(String fullCommand) {
        String[] s1 = fullCommand.split(" ");
        String[] s2 = fullCommand.split(" /");
        return s2[0].replace(s1[0] + " ", "");
    }

    public static Date date(String fullCommand) throws InputErrorException {
        String[] str = fullCommand.split("\\/");
        if (str.length != 3) {
            throw new InputErrorException("AddCommandFormatWrong");
        }
        return convertStrToDate(str[1]);
    }

    public static String sortingIndex(String fullCommand) {
        return fullCommand.split(" ")[1];
    }

    public static double amount(String fullCommand) {
        String dollar = fullCommand.split(" /SGD")[1];

        assert (!dollar.matches("\\d++")) : "Amount must be number!";
        return Double.parseDouble(fullCommand.split(" /SGD")[1]);
    }

    private static Date convertStrToDate(String date) throws InputErrorException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

        try {
            return formatter.parse(date);
        } catch (ParseException p) {
            throw new InputErrorException("DateFormatError");
        }
    }

    public static String getListType(String fullCommand) throws InputErrorException {
        String[] s1 = fullCommand.split(" ");

        if (s1.length > 2) {
            throw new InputErrorException("ListCommandFormatError");
        } else if (s1.length == 2 && s1[0].toLowerCase().equals("list")) {
            String typeCode = Character.toString(s1[1].charAt(1));

            if (typeCode != "i" && typeCode != "c" && typeCode != "e" && typeCode != "d") {
                throw new InputErrorException("InValidListTypeCode");
            }

            return typeCode;
        } else {
            if (s1[0].toLowerCase().equals("list")) {
                return "o";
            }

            throw new InputErrorException("InvalidCommand");
        }
    }

    public static String getCategory(String fullCommand) throws InputErrorException {
        String[] str = fullCommand.split("\\/");
        if (str.length == 4) {
            return str[3];
        } else if (str.length == 3) {
            return "No Category";
        } else {
            throw new InputErrorException("InvalidAddCommandFormat");
        }
    }
}
