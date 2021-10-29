package seedu.duke.command;

import seedu.duke.ItemList;
import seedu.duke.UI;

public class ExitCommand extends Command {
    public ExitCommand(String fullCommand) {
        super(fullCommand);
    }

    public void run(ItemList itemList) {
        UI.byeMessage();
    }
}
