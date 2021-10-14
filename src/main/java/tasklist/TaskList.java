package tasklist;

import task.Task;

import java.util.ArrayList;

/**
* Serve as a store for saving user command.
*/
public class TaskList {
    private static TaskList taskList = null;
    private static ArrayList<Task> list = new ArrayList<>();

    public static TaskList getInstance() {
        if (taskList == null) {
            taskList = new TaskList();
        }
        return taskList;
    }

    public ArrayList<Task> getList() {
        return list;
    }
    
    /**
     * Deletes a task from the task list.
     *
     * @param num The index of a task that is required to be removed from the task list.
     */
    public void deleteTask(int num) {
        list.remove(num);
    }

    /**
     * Returns the task from the specified index from the task list.
     *
     * @param num The index the task.
     * @return Task The task at the specified index.
     */
    public Task returnTask(int num) {
        return list.get(num);
    }

    /**
     * Returns the size of the current task list.
     *
     * @return int  The size of the current task list.
     */
    public int sizeOfTask() {
        return list.size();
    }
}

