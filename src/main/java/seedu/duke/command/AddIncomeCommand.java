package seedu.duke.command;

import seedu.duke.InputErrorException;
import seedu.duke.ItemList;
import seedu.duke.Parser;
import seedu.duke.UI;
import seedu.duke.Storage;

import java.util.Date;

public class AddIncomeCommand extends Command {
    public AddIncomeCommand(String fullCommand) {
        super(fullCommand);
    }

    public void run(ItemList itemList) throws InputErrorException {

        Storage storage = new Storage();

        String description = Parser.description(fullCommand);
        String category = Parser.category(fullCommand);
        Double amount = Parser.amount(fullCommand);
        Date date = Parser.date(fullCommand);

        itemList.addIncome(description, category, amount, date);
        int size = itemList.size;
        UI.addMessage(itemList.items.get(size - 1), size);
        storage.saveToStorage(itemList);
    }
}
