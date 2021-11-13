package command;

import constant.Utils;
import exception.ErrorHandler;
import storage.Storage;
import task.Appointment;
import task.Task;
import tasklist.TaskList;
import ui.Ui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class SearchByDateCommand extends Command {
    private final Date dateTime;

    public SearchByDateCommand(String dateTime) throws ErrorHandler {
        this.dateTime = this.parseDate(dateTime);
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) throws ErrorHandler {
        ArrayList<String> tasks = new ArrayList<>();
        for (Task task : list.getList()) {
            if (task instanceof Appointment) {
                Date currentDate = ((Appointment) task).getDateTime();
                if (this.isSameDay(this.dateTime, currentDate)) {
                    tasks.add(task.taskToStringFormat());
                }
            }
        }

        ui.printTasks(tasks);
    }

    private boolean isSameDay(Date target, Date current) {
        SimpleDateFormat dtf = new SimpleDateFormat(Utils.DATE_FORMAT);
        String targetDateString = dtf.format(target);
        String currentDateString = dtf.format(current);

        return targetDateString.equals(currentDateString);
    }
}
