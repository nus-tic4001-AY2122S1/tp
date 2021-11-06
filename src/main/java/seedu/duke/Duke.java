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
        Storage fileStorage = new Storage();
        fileStorage.loadFromStorage(this.itemList);

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
                String fullCommand = UI.readCommand();
                Execution execution = new Execution(fullCommand);
                execution.execute(itemList);
                isExit = execution.isExit;
            } catch (InputErrorException d) {
                switch (d.getErrorType()) {
                case "InvalidCommand":
                    InputErrorException.toPrintInvalidCommand();
                    break;
                case "AmountNotNumber":
                    InputErrorException.toPrintAmountNotNumber();
                    break;
                case "DateFormatError":
                    InputErrorException.toPrintDateFormatError();
                    break;
                case "InputInfoShortage":
                    InputErrorException.toPrintInputInfoShortage();
                    break;
                case "IndexOutOfRange":
                    InputErrorException.toPrintIndexOutOfRange();
                    break;
                case "IndexNotInt":
                    InputErrorException.toPrintIndexNotInt();
                    break;
                case "SortFormatError":
                    InputErrorException.toPrintSortFormatError();
                    break;
                case "SortByEmptyFileList":
                    InputErrorException.toPrintEmptyFileError();
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
