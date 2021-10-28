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

        //If the user input is not correct, the system will ask user to try until the input is correct
        boolean isCorrect = false;
        while (!isCorrect) {
            try {
                System.out.println("Please key in the index:");
                String inputIndex = UI.readCommand();
                final int index = Parser.index(inputIndex);

                if (index < 0 || index > itemList.size - 1) {
                    throw new InputErrorException("IndexOutOfRange");
                }

                isCorrect = true;

                Item deletedTask = itemList.items.get(index);
                itemList.delete(index);
                UI.deleteMessage(deletedTask, itemList.size);

            } catch (InputErrorException e) {
                String errorType = e.getErrorType();
                if (errorType.equals("IndexOutOfRange")) {
                    InputErrorException.toPrintIndexOutOfRange();
                } else if (errorType.equals("IndexNotInt")) {
                    InputErrorException.toPrintIndexNotInt();
                } else {
                    System.out.println("OOPS!!! SOMETHING WRONG! PLEASE TRY AGAIN.");
                }
            }
        }
    }
}