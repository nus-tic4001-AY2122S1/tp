package seedu.duke.command;

import seedu.duke.itemList;
import seedu.duke.InputErrorException;
import seedu.duke.Parser;
import seedu.duke.UI;

import java.util.Date;

public class AddExpenseCommand extends Command {
    public AddExpenseCommand(String command) {
        super(command);
    }

    public void run(itemList itemList) throws InputErrorException {
        System.out.println("Please key in the expense description:");
        String description = UI.readCommand();
        System.out.println("Please key in the category:");
        String category = UI.readCommand();
        System.out.println("Please key in the amount:");
        String inputAmount = UI.readCommand();
        Double amount = Parser.amount(inputAmount);
        System.out.println("Please key in the date:");
        String inputDate = UI.readCommand();
        Date date = Parser.date(inputDate);

        itemList.addExpense(description, category, amount, date);
        int size = itemList.size;
        UI.addMessage(itemList.items.get(size - 1), size);
    }
}
