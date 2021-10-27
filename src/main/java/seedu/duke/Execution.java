package seedu.duke;

import seedu.duke.command.AddExpenseCommand;
import seedu.duke.command.AddIncomeCommand;
import seedu.duke.command.DeleteCommand;
import seedu.duke.command.ExitCommand;
import seedu.duke.command.FindCommand;
import seedu.duke.command.ListCommand;
//import seedu.duke.command.SortCommand;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Execution {
    protected String command;
    protected boolean isExit;

    public Execution(String command) {
        this.command = command;
        this.isExit = false;
    }

    public void execute(itemList itemList) throws InputErrorException {
        Logger logger = Logger.getLogger("Foo");

        switch (command) {
        case "list":
            new ListCommand(command).run(itemList);
            break;
        case "expense":
            new AddIncomeCommand(command).run(itemList);
            break;
        case "income":
            new AddExpenseCommand(command).run(itemList);
            break;
        case "delete":
            new DeleteCommand(command).run(itemList);
            break;
        //case "sort":
            //new SortCommand(command).run(itemList);
            //break;
        case "find":
            new FindCommand(command).run(itemList);
            break;
        case "exit":
            new ExitCommand(command).run(itemList);
            isExit = true;
            break;
        default:
            System.out.println("Please key in valid command!");
        }
    }
}
