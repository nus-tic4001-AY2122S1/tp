package command;

import constant.ErrorMessage;
import exception.ErrorHandler;
import storage.Storage;
import task.Appointment;
import task.Task;
import tasklist.TaskList;
import ui.Ui;
import java.util.Date;

public class AppointmentTimeCommand extends Command {
    private final int taskIndex;
    private final Date time;

    public AppointmentTimeCommand(String taskNumber, String time) throws ErrorHandler {
        this.taskIndex = this.parseTaskNumberToIndex(taskNumber);
        this.time = this.parseDateTime(time);
    }

    public void execute(TaskList list, Ui ui, Storage storage) throws ErrorHandler {
        this.checkTaskNumberOutOfRange(this.taskIndex, list);
        Task task = list.returnTask(this.taskIndex);

        if (task instanceof Appointment) {
            ((Appointment) task).setTime(this.time);
            ui.printUpdatedTask(task.taskToStringFormat(), list.sizeOfTask());
        } else {
            ui.print(ErrorMessage.INVALID_APPOINTMENT_TASK);
        }
    }
}
