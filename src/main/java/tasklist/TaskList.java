package tasklist;

import task.Task;

import java.util.ArrayList;

/**
* Serve as a store for saving user command.
*/
public class TaskList {
    private static TaskList taskList = null;
    private static ArrayList<Task> todoList = new ArrayList<>();

    public static TaskList getInstance() {
        if (taskList == null) {
            taskList = new TaskList();
        }
        return taskList;
    }

    public ArrayList<Task> getList() {
        return todoList;
    }
}

