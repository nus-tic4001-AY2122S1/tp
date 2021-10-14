package seedu.duke.command;

import seedu.duke.ExpenseList;
import seedu.duke.Parser;
import seedu.duke.UI;
import seedu.duke.expense.Expense;
import java.util.logging.Logger;
import java.util.logging.Level;

public class DeleteCommand extends Command {
    public DeleteCommand(String fullCommand) {

        super(fullCommand);
    }

    private static Logger logger = Logger.getLogger("YSG");

    public void run(ExpenseList expenseList) {
        // log a message at INFO level
        logger.log(Level.INFO, "Duke Expense deleting processing");

        int index = Parser.index(fullCommand);
        assert (index >= 0) : "Index number cannot smaller than 0!";
        assert (index < expenseList.size - 1) : "Invalid index number!";

        Expense deletedTask = expenseList.expenses.get(index);
        expenseList.delete(index);
        UI.deleteMessage(deletedTask, expenseList.size);
    }
}