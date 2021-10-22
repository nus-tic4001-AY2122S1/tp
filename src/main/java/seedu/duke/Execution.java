package seedu.duke;

import seedu.duke.command.AddExpenseCommand;
import seedu.duke.command.AddIncomeCommand;
import seedu.duke.command.DeleteCommand;
import seedu.duke.command.ExitCommand;
import seedu.duke.command.FindCommand;
import seedu.duke.command.ListCommand;
import seedu.duke.command.AddIncomeCommand;
import seedu.duke.command.SortCommand;

public class Execution {
    protected String fullCommand;
    protected String command;
    protected boolean isExit;

    public Execution(String fullCommand) {
        this.fullCommand = fullCommand;
        this.command = Parser.command(fullCommand);
        this.isExit = false;
    }

    public void execute(ExpenseList expenseList) {
        switch (command) {
        case "list":
            new ListCommand(fullCommand).run(expenseList);
            break;
        case "add":
            new AddExpenseCommand(fullCommand).run(expenseList);
            break;
        case "delete":
            new DeleteCommand(fullCommand).run(expenseList);
            break;
        case "income":
            new AddIncomeCommand(fullCommand).run(expenseList);
            break;
        case "sort":
            new SortCommand(fullCommand).run(expenseList);
            break;
        case "find":
            new FindCommand(fullCommand).run(expenseList);
            break;
        case "exit":
            new ExitCommand(fullCommand).run(expenseList);
            isExit = true;
            break;
        default:
            System.out.println("Please key in valid command!");
        }
    }
}
