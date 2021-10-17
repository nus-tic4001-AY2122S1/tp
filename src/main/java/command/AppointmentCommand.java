package command;

import storage.Storage;
import task.Appointment;
import task.Todo;
import tasklist.TaskList;
import ui.Ui;

public class AppointmentCommand extends Command{
    private final String taskDescription;
    private final String at;
    private final String location;

    public AppointmentCommand(String description, String at, String location) {
        this.taskDescription = description;
        this.at = at;
        this.location = location;
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        Appointment addedAppointment = new Appointment(this.taskDescription,  this.at, this.location);
        list.addItem(addedAppointment);

        ui.printAddedTask(addedAppointment.taskToStringFormat(), list.sizeOfTask());
    }
}
