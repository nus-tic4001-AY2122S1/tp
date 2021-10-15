package seedu.duke.command;

import seedu.duke.ExpenseList;
import seedu.duke.UI;

import java.util.logging.Logger;
import java.util.logging.Level;


public class ListCommand extends Command {
    public ListCommand(String fullCommand) {
        super(fullCommand);
    }

    private static Logger logger = Logger.getLogger("INFO");

    public void run(ExpenseList expenseList) {
        // log a message at INFO level
        logger.log(Level.INFO, "Duke start to display a list of expenses");
        UI.listMessage(expenseList.expenses);
    }
}
