package seedu.duke;

public class Parser {
    public static String command(String fullCommand) {
        return fullCommand.split(" ")[0].toLowerCase();
    }

    public static int index(String fullCommand) {
        String buffer = fullCommand.split(" ")[1];

        assert (!buffer.matches("\\d+")) : "Index must be Integer!";
        return Integer.parseInt(fullCommand.split(" ")[1]) - 1;
    }

    public static String description(String fullCommand) {
        String[] s1 = fullCommand.split(" ");
        String[] s2 = fullCommand.split(" /");
        return s2[0].replace(s1[0] + " ", "");
    }

    public static String date(String fullCommand) {
        String[] s1 = fullCommand.split(" /SGD");
        String[] s2 = s1[0].split(" /");
        return s2[1];
    }

    public static double amount(String fullCommand) {
        return Double.parseDouble(fullCommand.split(" /SGD")[1]);
    }
}
