package Command;

import exception.ErrorHandler;
import storage.Storage;
import taskList.TaskList;
import ui.Ui;

public class LocationCommand extends Command {
    private int taskNumber;
    private String location;

    public LocationCommand (String taskNumber, String location ) throws ErrorHandler {
        this.taskNumber = this.pareTaskNumber(taskNumber);
        this.location = location;
    }

    public void execute(Storage storage, Ui ui, TaskList taskList)  {
        System.out.println("pending implementation for setting location for appointment");
    }
}
