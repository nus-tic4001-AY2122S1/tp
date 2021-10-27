package seedu.duke.command;

import seedu.duke.ItemList;
import seedu.duke.UI;

public class ExitCommand extends Command {
    public ExitCommand(String command) {
        super(command);
    }

    public void run(ItemList itemList) {
        UI.byeMessage();
    }
}
