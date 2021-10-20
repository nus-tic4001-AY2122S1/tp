package seedu.duke.command;

import seedu.duke.ExpenseList;
import seedu.duke.Parser;
import seedu.duke.UI;

public class AddIncomeCommand extends Command {
    public AddIncomeCommand(String fullCommand) {
        super(fullCommand);
    }

    public void run(ExpenseList expenseList) {
        String date = Parser.date(fullCommand);
        String description = Parser.description(fullCommand);
        double amount = Parser.amount(fullCommand);
        expenseList.addIncome(date, description, amount);
        int size = expenseList.size;
        UI.addMessageIncome(expenseList.expenses.get(size - 1), size);
    }
}
