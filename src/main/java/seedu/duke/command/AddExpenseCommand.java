package seedu.duke.command;

import seedu.duke.ExpenseList;
import seedu.duke.Parser;
import seedu.duke.UI;

public class AddExpenseCommand extends Command {
    public AddExpenseCommand(String fullCommand) {
        super(fullCommand);
    }

    public void run(ExpenseList expenseList) {
        String date = Parser.date(fullCommand);
        String description = Parser.description(fullCommand);
        double amount = Parser.amount(fullCommand);
        expenseList.addExpense(date, description, amount);
        int size = expenseList.size;
        UI.addMessage(expenseList.expenses.get(size - 1), size);
    }
}
