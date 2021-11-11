package command;

import constant.ErrorMessage;
import exception.ErrorHandler;
import storage.Storage;
import task.Assignment;
import task.Task;
import tasklist.TaskList;
import ui.Ui;

public class ProgressionCommand extends Command {
    private final int taskIndex;
    private final String progression;

    public ProgressionCommand(String taskNumber, String progression) throws ErrorHandler {
        this.taskIndex = this.parseTaskNumberToIndex(taskNumber);
        this.progression = progression;
    }

    public void execute(TaskList list, Ui ui, Storage storage) throws ErrorHandler {
        this.checkTaskNumberOutOfRange(this.taskIndex, list);
        Task task = list.returnTask(this.taskIndex);

        if (task instanceof Assignment) {
            ((Assignment) task).setProgressionLevel(this.progression);
            ui.printUpdatedTask(task.taskToStringFormat(), list.sizeOfTask());
        } else {
            ui.print(ErrorMessage.INVALID_ASSIGNMENT_TASK);
        }
    }
}
