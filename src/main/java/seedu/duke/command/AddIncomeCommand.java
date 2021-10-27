package seedu.duke.command;

import seedu.duke.InputErrorException;
import seedu.duke.ItemList;
import seedu.duke.Parser;
import seedu.duke.UI;

import java.util.Date;

public class AddIncomeCommand extends Command {
    public AddIncomeCommand(String command) {
        super(command);
    }

    public void run(ItemList itemList) throws InputErrorException {
        System.out.println("Please key in the income description:");
        final String description = UI.readCommand();
        System.out.println("Please key in the category:");
        final String category = UI.readCommand();
        System.out.println("Please key in the amount:");
        String inputAmount = UI.readCommand();
        final Double amount = Parser.amount(inputAmount);
        System.out.println("Please key in the date:");
        String inputDate = UI.readCommand();
        final Date date = Parser.date(inputDate);

        itemList.addIncome(description, category, amount, date);
        int size = itemList.size;
        UI.addMessage(itemList.items.get(size - 1), size);
    }
}
