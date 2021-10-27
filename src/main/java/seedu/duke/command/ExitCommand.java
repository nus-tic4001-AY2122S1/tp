package seedu.duke.command;

import seedu.duke.itemList;
import seedu.duke.UI;

public class ExitCommand extends Command {
    public ExitCommand(String command) {
        super(command);
    }

    public void run(itemList itemList) {
        UI.byeMessage();
    }
}
