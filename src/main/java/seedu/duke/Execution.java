package seedu.duke;

import seedu.duke.command.*;

import java.util.logging.Logger;

public class Execution {
    protected String fullCommand;
    protected String command;
    protected boolean isExit;

    public Execution(String fullCommand) {
        this.fullCommand = fullCommand;
        this.command = Parser.command(fullCommand);
        this.isExit = false;
    }

    public void execute(ItemList itemList) throws InputErrorException {
        Logger logger = Logger.getLogger("Foo");

        switch (command) {
        case "list":
            new ListCommand(fullCommand).run(itemList);
            break;
        case "expense":
            new AddExpenseCommand(fullCommand).run(itemList);
            break;
        case "income":
            new AddIncomeCommand(fullCommand).run(itemList);
            break;
        case "delete":
            new DeleteCommand(fullCommand).run(itemList);
            break;
        case "sort":
            new SortCommand(fullCommand).run(itemList);
            break;
        case "find":
            new FindCommand(fullCommand).run(itemList);
            break;
        case "exit":
            new ExitCommand(fullCommand).run(itemList);
            isExit = true;
            break;
        case "summary":
            new SummaryCommand().run(itemList);
            break;
        default:
            System.out.println("Please key in valid command!");
        }
    }
}
