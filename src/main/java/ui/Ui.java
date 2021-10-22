package ui;

import task.Task;
import category.Category;
import tasklist.TaskList;

/**
 * Ui class is only for printing message.
 */
public class Ui {
    public void welcome() {
        print("Hello! I'm Dafy\n");
    }

    public void print(String message) {
        System.out.println(message);
    }

    /**
     * Displays an empty line.
     */
    public void printEmptyLine() {
        System.out.println("\n");
    }

    /**
     * Displays a number of tasks in the Tasklist.
     */
    public void printTaskNum(TaskList tasks, Task task) {
        System.out.println(task + "\n   Now you have " + tasks.sizeOfTask() + " tasks in the list.\n");
    }

    /**
     * Displays the response when a task is deleted.
     */
    public void printDeleteCommand(String task, int num) {
        System.out.println("   Noted. I've removed this task:\n   " + task + "\n   Now you have " + num
            + " tasks in the list.");
    }

    /**
     * Shows a list of tasks to the user, formatted as an indexed list.
     */
    public void printTaskList(TaskList list) {
        for (int i = 1; i <= list.sizeOfTask(); i++) {
            System.out.print("   " + i + ". ");
            System.out.println(list.returnTask(i - 1).taskToStringFormat());
        }
    }

    /**
     * Shows a list of tasks to the user, formatted as an indexed list.
     */
    public void printCategoryList(Category list) {
        for (int i = 1; i <= list.size(); i++) {
            System.out.print("   " + i + ". ");
            System.out.println(list.getCategory(i - 1));
        }
    }

    /**
     * Displays the response when a task is added.
     */
    public void printAddedTask(String task, int num) {
        System.out.println("   Noted. I've added this task:\n   " + task + "\n   Now you have " + num
            + " tasks in the list.");
    }

    public void bye() {
        print("Bye. Hope to see you again soon!");
    }
}
