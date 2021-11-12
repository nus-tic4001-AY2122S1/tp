package seedu.duke.command;

import seedu.duke.ItemList;
import seedu.duke.UI;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;
import java.util.ArrayList;

public class ListCommand extends Command {
    public ListCommand(String fullCommand) {
        super(fullCommand);
    }

    private static Logger logger = Logger.getLogger("LIST");

    public void run(ItemList itemList) {
        // log a message at INFO level
        ArrayList<String> messages = new ArrayList<>();
        messages.add("Here are the tasks in your list:");
        UI.listMessage(itemList.items);
        FileHandler fh;

        try {
            fh = new FileHandler("./src/log/ListLogFile.log");
            logger.addHandler(fh);
            logger.setUseParentHandlers(false);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.log(Level.INFO, "Duke start to display a list of expenses");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
