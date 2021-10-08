package seedu.duke.command;

import seedu.duke.Ui;

public class ExitCommand extends Command {

    @Override
    public void execute() {
        Ui.exitMsg();
    }

    public static boolean isExit(Command command) {
        return command instanceof ExitCommand; // instanceof returns false if it is null
    }

}
