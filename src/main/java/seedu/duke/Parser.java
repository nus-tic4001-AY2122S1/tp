package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.command.ExitCommand;
import seedu.duke.command.PlaceholderCommand;

public class Parser {
    public static Command parse(String fullCommand) {
        String keyCommand;
        Ui ui = new Ui();
        try {
            String userInstruction = ui.readCommand();
            keyCommand = userInstruction.split(" ")[0].toLowerCase();
        } catch (Exception e) {
            keyCommand = "exit";
        }
        switch (keyCommand) {
        case ("add"):
            return new PlaceholderCommand("add");

        case ("list"):
            return new PlaceholderCommand("list");

        case ("view"):
            return new PlaceholderCommand("view");

        case ("delete"):
            return new PlaceholderCommand("delete");

        case ("exit"):
        case ("bye"):
        case ("quit"):
            return new ExitCommand();

        default:
            System.out.println("Do nothing");
            return new PlaceholderCommand("Try again");
        }
    }
}
