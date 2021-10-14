package command;

import exception.ErrorHandler;
import storage.Storage;
import list.TaskList;
import ui.Ui;

public class LocationCommand extends Command {
    private final int taskNumber;
    private final String location;

    public LocationCommand(String taskNumber, String location) throws ErrorHandler {
        this.taskNumber = this.parseTaskNumber(taskNumber);
        this.location = location;
    }

    public void execute(Storage storage, Ui ui, TaskList taskList) {
        System.out.println("pending implementation for setting location for appointment task. "
            + "Waiting for implementation of Appointment task");
    }
}
