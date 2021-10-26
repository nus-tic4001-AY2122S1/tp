package seedu.duke.command;

import seedu.duke.ExpenseList;
import seedu.duke.InputErrorException;
import seedu.duke.Parser;
import seedu.duke.UI;

import java.sql.Timestamp;
import java.util.Date;

public class AddExpenseCommand extends Command {
    public AddExpenseCommand(String fullCommand) {
        super(fullCommand);
    }

    public void run(ExpenseList expenseList) throws InputErrorException {
        Date date = Parser.date(fullCommand);
        String description = Parser.description(fullCommand);
        double amount = Parser.amount(fullCommand);
        Date recordDate = new Date();
        long time = recordDate.getTime();
        Timestamp timestamp = new Timestamp(time);

        String category = Parser.getCategory(fullCommand);

        if (category.equals("No Category")) {
            expenseList.addExpense(date, description, amount, timestamp);
        } else {
            expenseList.addExpense(date, description, amount, timestamp, category);
        }

        int size = expenseList.size;

        UI.addMessage(expenseList.expenses.get(size - 1), size);
    }
}
