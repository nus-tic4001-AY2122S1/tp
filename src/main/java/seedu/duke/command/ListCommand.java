package seedu.duke.command;

import seedu.duke.ExpenseList;
import seedu.duke.InputErrorException;
import seedu.duke.Parser;
import seedu.duke.UI;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;


public class ListCommand extends Command {
    private String type;

    public ListCommand(String fullCommand) throws InputErrorException {
        super(fullCommand);
        this.type = Parser.getListType(fullCommand);
    }

    private static Logger logger = Logger.getLogger("LIST");

    public void run(ExpenseList expenseList) {
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

        UI.listMessage(expenseList.expenses);
    }
}
