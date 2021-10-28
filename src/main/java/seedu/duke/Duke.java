package seedu.duke;

import seedu.duke.item.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

public class Duke {
    private ItemList itemList;
    private static Logger logger = Logger.getLogger("Foo");

    private Duke() {
        ArrayList<Item> items = new ArrayList<>();
        this.itemList = new ItemList(items);
    }

    private void run() {
        UI.welcome();
        // log a message at INFO level
        FileHandler fh;
        try {
            fh = new FileHandler("./log/ExpensesTrackerLogFile.log");
            logger.addHandler(fh);
            logger.setUseParentHandlers(false);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.log(Level.INFO, "Duke start processing");
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean isExit = false;
        while (!isExit) {
            try {
                logger.log(Level.INFO, "New input to execute");
                String command = UI.readCommand();
                Execution execution = new Execution(command);
                execution.execute(itemList);
                isExit = execution.isExit;
            } catch (InputErrorException d) {
                switch (d.errorType) {
                case "ListCommandFormatError":
                    InputErrorException.toPrintListFormatError();
                    break;
                case "InvalidCommand":
                    InputErrorException.toPrintInvalidCommand();
                    break;
                default:
                    System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            }
        }
    }

    public static void main(String[] args) {
        new Duke().run();
    }
}
