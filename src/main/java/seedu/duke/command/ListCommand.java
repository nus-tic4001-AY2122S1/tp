package seedu.duke.command;

import seedu.duke.ExpenseList;
import seedu.duke.InputErrorException;
import seedu.duke.Parser;
import seedu.duke.UI;

public class ListCommand extends Command {
    private String type;

    /**
     * To initial ListCommand variable
     * Input format: "list" + space + "-type"
     *
     * Four types list command: i stand for income
     *                          c stand for category
     *                          d stand for date
     *                          e stand for expense
     *
     * @param fullCommand The entire command user input
     */
    public ListCommand(String fullCommand) throws InputErrorException {
        super(fullCommand);
        this.type = Parser.getListType(fullCommand);
    }

    public void run(ExpenseList expenseList) {

/*        switch(type) {
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
