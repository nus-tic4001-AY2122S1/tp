package command;

import exception.ErrorHandler;
import taskList.TaskList;
import ui.Ui;
import storage.Storage;

/**
 * Represents an executable command.
 */

public class Command {
    protected static Ui ui = new Ui();

    public boolean isExit() {
        return false;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) throws ErrorHandler  {
        throw new ErrorHandler("I'm sorry, but I don't know what that means.");
    }

}


