package seedu.duke.command;

import seedu.duke.ExpenseList;
import seedu.duke.UI;

public class ListCommand extends Command {
    public ListCommand(String fullCommand) {
        super(fullCommand);
    }

    public void run(ExpenseList expenseList) {

        UI.listMessage(expenseList.expenses);
    }
}
