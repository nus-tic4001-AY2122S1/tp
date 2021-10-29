package seedu.duke.command;

import seedu.duke.ItemList;
import seedu.duke.Parser;
import seedu.duke.UI;

import java.util.ArrayList;

public class FindCommand extends Command {
    public FindCommand(String fullCommand) {
        super(fullCommand);
    }

    public void run(ItemList itemList) {
        String keyword = Parser.description(fullCommand);
        ArrayList<Integer> findResult = new ArrayList<>();
        itemList.find(keyword, findResult);
        UI.findMessage(itemList.items, findResult);
    }
}
