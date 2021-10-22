package command;

import exception.ErrorHandler;
import storage.Storage;
import task.Appointment;
import tasklist.TaskList;
import ui.Ui;

import java.util.Date;

public class AppointmentCommand extends Command {
    private final String taskDescription;
    private final Date at;
    private final String location;

    public AppointmentCommand(String description, String at, String location) throws ErrorHandler {
        this.taskDescription = description;
        this.at = this.parseDateTime(at);
        this.location = location;
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        Appointment addedAppointment = new Appointment(this.taskDescription, this.at, this.location);
        list.addItem(addedAppointment);

        ui.printAddedTask(addedAppointment.taskToStringFormat(), list.sizeOfTask());
    }
}
