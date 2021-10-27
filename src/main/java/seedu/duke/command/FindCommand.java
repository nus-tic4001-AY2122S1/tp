package seedu.duke.command;

import seedu.duke.ItemList;
import seedu.duke.UI;

import java.util.ArrayList;

public class FindCommand extends Command {
    public FindCommand(String command) {
        super(command);
    }

    public void run(ItemList itemList) {
        System.out.println("Please key in the keyword:");
        final String keyword = UI.readCommand();
        ArrayList<Integer> findResult = new ArrayList<>();
        itemList.find(keyword, findResult);
        UI.findMessage(itemList.items, findResult);
    }
}
