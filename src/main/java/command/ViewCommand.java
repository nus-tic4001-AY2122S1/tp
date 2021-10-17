package command;

import ui.Ui;
import storage.Storage;
import tasklist.TaskList;

/**
 * Lists all tasks in the task list to the user.
 */
public class ViewCommand extends Command {
    protected static Ui ui = new Ui();

    /**
     * Executes the command.
     *
     * @param list    The tasks stored in an ArrayList.
     * @param ui      The User Interface (UI).
     * @param storage The storage to allow reading and storing of tasks from and to a txt file.
     */
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        if (list.sizeOfTask() == 0) {
            ui.print("The list is empty.");
        } else {
            ui.printTaskList(list);
        }
    }
}
