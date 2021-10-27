package seedu.duke.command;

import seedu.duke.itemList;
import seedu.duke.UI;

import java.util.ArrayList;

public class FindCommand extends Command {
    public FindCommand(String command) {
        super(command);
    }

    public void run(itemList itemList) {
        System.out.println("Please key in the keyword:");
        String keyword = UI.readCommand();
        ArrayList<Integer> findResult = new ArrayList<>();
        itemList.find(keyword, findResult);
        UI.findMessage(itemList.items, findResult);
    }
}
