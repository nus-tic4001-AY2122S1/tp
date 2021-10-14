package command;

import exception.ErrorHandler;
import storage.Storage;
import task.Todo;
import tasklist.TaskList;
import ui.Ui;

public class TodoCommand extends Command {
    private final String taskDescription;

    public TodoCommand(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        Todo addedTodo = new Todo(this.taskDescription);
        list.addItem(addedTodo);

        ui.printAddedTask(addedTodo.taskToStringFormat(), list.sizeOfTask());
    }
}
