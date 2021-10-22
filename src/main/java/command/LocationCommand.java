package command;

import constant.ErrorMessage;
import exception.ErrorHandler;
import storage.Storage;
import task.Appointment;
import task.Task;
import tasklist.TaskList;
import ui.Ui;

public class LocationCommand extends Command {
    private final int taskIndex;
    private final String location;

    public LocationCommand(String taskNumber, String location) throws ErrorHandler {
        this.taskIndex = this.parseTaskNumberToIndex(taskNumber);
        this.location = location;
    }

    public void execute(TaskList list, Ui ui, Storage storage) throws ErrorHandler {
        this.checkTaskNumberOutOfRange(this.taskIndex, list);
        Task task = list.returnTask(this.taskIndex);

        if(task instanceof Appointment) {
            ((Appointment) task).setLocation(this.location);
            ui.printUpdatedTask(task.taskToStringFormat(), list.sizeOfTask());
        } else {
            ui.print(ErrorMessage.INVALID_APPOINTMENT_TASK);
        }
    }
}
