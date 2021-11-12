package command;

import storage.Storage;
import task.Task;
import tasklist.TaskList;
import ui.Ui;

public class TaskProgressCommand extends Command {
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        int completedTaskCount = 0;
        int numberOfTasks = list.sizeOfTask();
        for (Task task : list.getList()) {
            if (task.getStatus()) {
                completedTaskCount += 1;
            }
        }

        String percentage =
            numberOfTasks > 0 ? String.format("%.2f", (completedTaskCount * 100.0) / numberOfTasks) + "%" : "0%";
        ui.printProgress(completedTaskCount, list.sizeOfTask(), percentage);
    }
}
