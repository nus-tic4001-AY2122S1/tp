package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.command.AddCommand;
import seedu.duke.command.ExitCommand;
import seedu.duke.command.ListCommand;
import seedu.duke.command.MyListCommand;
import seedu.duke.command.DeleteCommand;
import seedu.duke.command.PlaceholderCommand;
import seedu.duke.command.SaveToStorageCommand;
import seedu.duke.command.LoadFromStorageCommand;
import seedu.duke.command.ViewCommand;
import seedu.duke.command.CheckCommand;

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
            return new AddCommand(subCommand);

        case ("list"):
            return new ListCommand(subCommand);

        case ("view"):
            return new ViewCommand(subCommand);

        case ("delete"):
            return new DeleteCommand(subCommand);

        case ("mylist"):
            return new MyListCommand();

        case ("save"):
            return new SaveToStorageCommand("save");

        case ("load"):
            return new LoadFromStorageCommand("load");

        case ("check"):
            return new CheckCommand(subCommand);

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
