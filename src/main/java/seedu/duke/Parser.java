package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.command.ExitCommand;
import seedu.duke.command.ListCommand;
import seedu.duke.command.PlaceholderCommand;

public class Parser {
    public static Command parse(String fullCommand) {
        // Trim to get KeyCommand
        String keyCommand;
        try {
            keyCommand = fullCommand.split(" ")[0].toLowerCase();
        } catch (Exception e) {
            keyCommand = "";
        }
        // Trim to get SubCommand
        String subCommand;
        try {
            subCommand = fullCommand.split(" ")[1];
        } catch (Exception e) {
            subCommand = " ";
        }
        switch (keyCommand) {
        case ("add"):
            return new PlaceholderCommand("add");

        case ("list"):
            return new ListCommand(subCommand);

        case ("view"):
            return new PlaceholderCommand("view");

        case ("delete"):
            return new PlaceholderCommand("delete");

        case ("exit"):
        case ("bye"):
        case ("quit"):
            System.out.println("Do exit");
            return new ExitCommand();
        default:
            return new PlaceholderCommand("Try again"); //temp place holder
        }
    }
}
