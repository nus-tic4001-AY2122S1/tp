package seedu.duke.command;

import seedu.duke.ExpenseList;

public abstract class Command {
    protected String fullCommand;

    public Command(String fullCommand) {
        this.fullCommand = fullCommand;
    }

    public abstract void run(ExpenseList expenseList);
}
