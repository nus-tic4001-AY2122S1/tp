package seedu.duke.command;

import seedu.duke.ExpenseList;
import seedu.duke.Parser;
import seedu.duke.UI;
import seedu.duke.expense.Expense;

public class DeleteCommand extends Command {
    public DeleteCommand(String fullCommand) {
        super(fullCommand);
    }

    public void run(ExpenseList expenseList) {
        int index = Parser.index(fullCommand);
        assert (index < expenseList.size - 1) : "Invalid index number!";
        Expense deletedTask = expenseList.expenses.get(index);
        expenseList.delete(index);
        UI.deleteMessage(deletedTask, expenseList.size);
    }
}