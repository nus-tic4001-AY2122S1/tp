package seedu.duke.command;

import seedu.duke.InputErrorException;
import seedu.duke.ItemList;
import seedu.duke.Parser;
import seedu.duke.UI;
import seedu.duke.item.Item;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

public class DeleteCommand extends Command {
    public DeleteCommand(String command) {
        super(command);
    }

    private static Logger logger = Logger.getLogger("DELETE");

    public void run(ItemList itemList) throws InputErrorException {
        // log a message at INFO level
        FileHandler fh;
        try {
            fh = new FileHandler("./log/DeleteLogFile.log");
            logger.addHandler(fh);
            logger.setUseParentHandlers(false);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.log(Level.INFO, "Duke Expense deleting processing");
        } catch (IOException e) {
            e.printStackTrace();
        }

        int index = Parser.index(fullCommand);
        Item deletedTask = itemList.items.get(index);
        itemList.delete(index);
        UI.deleteMessage(deletedTask, itemList.size);
    }
}