package seedu.duke;

public class Parser {
    public static String parse(String fullCommand) {
        String keyCommand = fullCommand.split(" ")[0].toLowerCase();
        switch (keyCommand) {
        case ("list"):
        return "list";

        default:
        return "lol";
        }

    }
}
