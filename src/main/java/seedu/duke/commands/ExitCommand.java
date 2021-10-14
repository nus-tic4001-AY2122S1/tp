package seedu.duke.commands;

import seedu.duke.storage.GTDList;

import java.util.ArrayList;

/**
 * Exit the program.
 */
public class ExitCommand extends Command {

    public static final String COMMAND_WORD = "bye";


    @Override
    public void execute() {
        System.out.print("See you next time.\n");
    }

    public static boolean isExit(Command command) {
        return command instanceof ExitCommand; // instanceof returns false if it is null
    }
}
