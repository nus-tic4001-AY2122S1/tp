package seedu.duke.command;

import seedu.duke.ExpenseList;
import seedu.duke.Parser;
import seedu.duke.UI;

import java.util.ArrayList;

public class FindCommand extends Command {
    public FindCommand(String fullCommand) {
        super(fullCommand);
    }

    public void run(ExpenseList expenseList) {
        String keyword = Parser.description(fullCommand);
        ArrayList<Integer> findResult = new ArrayList<>();
        expenseList.find(keyword, findResult);
        UI.findMessage(expenseList.expenses, findResult);
    }
}
