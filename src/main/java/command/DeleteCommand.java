package command;

import exception.ErrorHandler;
import storage.Storage;
import tasklist.TaskList;
import ui.Ui;

/**
 * Deletes a task identified using it's index from the task list.
 */

public class DeleteCommand extends Command {
    protected static Ui ui = new Ui();
    private final int taskIndex;

    public DeleteCommand(String taskNumber) throws ErrorHandler {
        this.taskIndex = this.parseTaskNumberToIndex(taskNumber);
    }

    /**
     * Executes the command.
     *
     * @param list    The tasks stored in an ArrayList.
     * @param ui      The User Interface (UI).
     * @param storage The storage to allow reading and storing of tasks from and to a txt file.
     */
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) throws ErrorHandler {
        this.checkTaskNumberOutOfRange(this.taskIndex, list);

        String deletedItem = list.returnTask(this.taskIndex).taskToStringFormat();

        list.deleteTask(this.taskIndex);
        ui.printDeleteCommand(deletedItem, list.sizeOfTask());
    }
}
