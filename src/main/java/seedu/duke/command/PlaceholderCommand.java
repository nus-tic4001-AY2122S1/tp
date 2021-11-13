package seedu.duke.command;

import seedu.duke.ui.Ui;

/**
 * Place holder for command only. Please implement a real class.
 */
public class PlaceholderCommand extends Command {

    public PlaceholderCommand(String userInstruction) {
        super(userInstruction);
    }

    @Override
    public void execute() {
        Ui.printMsg(userInstruction);
    }
}
