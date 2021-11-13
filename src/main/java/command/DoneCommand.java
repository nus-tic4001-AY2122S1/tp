package command;

import exception.ErrorHandler;
import ui.Ui;
import storage.Storage;
import tasklist.TaskList;
import task.Task;


/**
 * Marks a task identified using it's index as done.
 */
public class DoneCommand extends Command {
    protected static Ui ui = new Ui();
    private final int taskIndex;

    public DoneCommand(String taskNumber) throws ErrorHandler {
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

        Task doneTask = list.returnTask(this.taskIndex);

        doneTask.setStatus(true);

        ui.printDoneCommand(doneTask.taskToStringFormat());
    }

}
