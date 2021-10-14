package seedu.duke.command;

import seedu.duke.ExpenseList;
import seedu.duke.UI;

public class ExitCommand extends Command {
    public ExitCommand(String fullCommand) {
        super(fullCommand);
    }

    public void run(ExpenseList expenseList) {
        UI.byeMessage();
    }
}
