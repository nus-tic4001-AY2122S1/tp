package seedu.duke.command;

import seedu.duke.ItemList;
import seedu.duke.InputErrorException;
import seedu.duke.Parser;
import seedu.duke.UI;

import java.util.Date;

public class AddExpenseCommand extends Command {
    public AddExpenseCommand(String command) {
        super(command);
    }

    public void run(ItemList itemList) throws InputErrorException {
        System.out.println("Please key in the expense description:");
        final String description = UI.readCommand();
        System.out.println("Please key in the category:");
        final String category = UI.readCommand();

        Date date = new Date();
        double amount = 0;
        boolean isCorrect = false;

        while (!isCorrect) {
            try {
                System.out.println("Please key in the amount:");
                String inputAmount = UI.readCommand();
                amount = Parser.amount(inputAmount);

                isCorrect = true;
            } catch (InputErrorException e) {
                InputErrorException.toPrintAmountNotNumber();
            }
        }

        isCorrect = false;
        while (!isCorrect) {
            try {
                System.out.println("Please key in the date:");
                String inputDate = UI.readCommand();
                date = Parser.date(inputDate);

                isCorrect = true;
            } catch (InputErrorException e) {
                InputErrorException.toPrintDateFormatError();
            }
        }

        itemList.addExpense(description, category, amount, date);
        int size = itemList.size;
        UI.addMessage(itemList.items.get(size - 1), size);
    }
}
