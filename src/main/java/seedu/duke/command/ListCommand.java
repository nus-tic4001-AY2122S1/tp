package seedu.duke.command;

import seedu.duke.ItemList;
import seedu.duke.UI;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;


public class ListCommand extends Command {
    public ListCommand(String command) {
        super(command);
    }

    private static Logger logger = Logger.getLogger("LIST");

    public void run(ItemList itemList) {
        // log a message at INFO level
        FileHandler fh;

        try {
            fh = new FileHandler("./log/ListLogFile.log");
            logger.addHandler(fh);
            logger.setUseParentHandlers(false);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.log(Level.INFO, "Duke start to display a list of expenses");
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*switch(type) {
            case "i":
                UI.listMessage(expenseList.expenses);
                break;
            case "c":
                UI.listMessage(expenseList.expenses);
                break;
            case "d":
                UI.listMessage(expenseList.expenses);
                break;
            case "e":
                UI.listMessage(expenseList.expenses);
        }*/
        UI.listMessage(itemList.items);
    }
}
