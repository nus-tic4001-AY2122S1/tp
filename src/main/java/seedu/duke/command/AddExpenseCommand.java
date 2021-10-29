package seedu.duke.command;

import seedu.duke.ItemList;
import seedu.duke.InputErrorException;
import seedu.duke.Parser;
import seedu.duke.UI;

import java.util.Date;

public class AddExpenseCommand extends Command {
    public AddExpenseCommand(String fullCommand) {
        super(fullCommand);
    }

    public void run(ItemList itemList) throws InputErrorException {
        String description = Parser.description(fullCommand);
        String category = Parser.category(fullCommand);
        double amount = Parser.amount(fullCommand);
        Date date = Parser.date(fullCommand);

        itemList.addExpense(description, category, amount, date);
        int size = itemList.size;
        UI.addMessage(itemList.items.get(size - 1), size);
    }
}
