package seedu.duke.command;


import seedu.duke.InputErrorException;
import seedu.duke.ItemList;
import seedu.duke.Parser;
import seedu.duke.UI;
import seedu.duke.item.Expense;
import seedu.duke.item.Income;
import seedu.duke.item.Item;
import seedu.duke.Storage;

import java.util.Date;

public class EditCommand extends Command {
    public EditCommand(String fullCommand) {
        super(fullCommand);
    }

    public void run(ItemList itemList) throws InputErrorException {
        int index = Parser.index(fullCommand);
        if (index < 0 || index >= itemList.size) {
            throw new InputErrorException("IndexOutOfRange");
        }
        Item temp = itemList.items.get(index);

        String editItem = Parser.editItem(fullCommand);
        String editItemType = Parser.command(editItem);
        String description = Parser.description(editItem);
        String category = Parser.category(editItem);
        Double amount = Parser.amount(editItem);
        Date date = Parser.date(editItem);

        switch (editItemType) {
        case "income":
            Income newIncome = new Income(description, category, amount, date, "income");
            itemList.edit(index, newIncome);
            break;
        case "expense":
            Expense newExpense = new Expense(description, category, amount, date, "expense");
            itemList.edit(index, newExpense);
            break;
        default:
            System.out.println("Please key in valid editing command!");
        }

        UI.editMessage(index, itemList.items, temp);
        Storage storage = new Storage();
    }
}
