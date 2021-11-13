package command;

import exception.ErrorHandler;
import storage.Storage;
import tasklist.TaskList;
import ui.Ui;

public class ByeCommand extends Command {
    public void execute(TaskList list, Ui ui, Storage storage) {
        this.isExit = true;
        ui.bye();
    }
}
