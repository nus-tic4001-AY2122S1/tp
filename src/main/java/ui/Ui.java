package ui;

import task.Appointment;
import task.Task;
import category.Category;
import tasklist.TaskList;

import java.util.Date;
import java.util.ArrayList;

import static helpers.DateConverter.removeTime;




/**
 * Ui class is only for printing message.
 */
public class Ui {
    public void welcome() {
        print("Hello! I'm Daffy\n");
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
     * Displays the response when a task is marked as done.
     */
    public void printDoneCommand(String task) {
        System.out.println("   Nice! I've marked this task as done:\n   " + task);
    }

    /**
     * Shows a list of tasks to the user, formatted as an indexed list.
     */
    public void printTaskList(TaskList list) {
        for (int i = 0; i < list.sizeOfTask(); i++) {
            System.out.print("   " + i + ". ");
            System.out.println(list.returnTask(i).taskToStringFormat());
        }
    }

    /**
     * Shows a list of tasks to the user, formatted as an indexed list.
     */
    public void printCategoryList(Category list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print("   " + i + ". ");
            System.out.println(list.getCategory(i));
        }
    }

    /**
     * Shows a list of pending tasks to the user, formatted as an indexed list.
     */
    public void printPendingTaskList(TaskList list) {
        int count = 0;
        for (int i = 0; i < list.sizeOfTask(); i++) {
            Task task = list.returnTask(i);
            if (!task.getStatus()) { // pending task
                count++;
                System.out.print("   " + i + ".");
                System.out.println(list.returnTask(i).taskToStringFormat());
            }
        }
        if (count == 0) { // no pending task
            System.out.print("   No pending tasks. Try command `view -a` to see all tasks.");
        }
    }

    /**
     * Prints a list of task filtered based on a specific task type.
     *
     * @param list existing task list.
     * @param input task to be filtered from the list.
     */
    public void printByTaskType(TaskList list, String input) {
        int count = 0;
        String type;

        if (input.equals("TODO")) {
            type = "T";
        } else {
            type = "A";
        }

        for (int i = 0; i < list.sizeOfTask(); i++) {
            Task task = list.returnTask(i);
            if (task.getType() == type) {
                count++;
                printTask(task, count);
            }
        }
        if (count == 0) { // no pending task
            printNoTask();
        }
    }

    /**
     * Prints a list of task filtered based on a specific date.
     *
     * @param list existing task list.
     * @param date date to be filtered from the list.
     */
    public void printByDate(TaskList list, Date date) {
        int count = 0;
        for (int i = 0; i < list.sizeOfTask(); i++) {
            Task task = list.returnTask(i);
            if (task.getType() == "A" && date.compareTo(removeTime(task.getDate())) == 0) {
                count++;
                printTask(task, count);
            }
        }
        if (count == 0) { // no pending task
            printNoTask();
        }
    }

    /**
     * Prints a list of task filtered based on a specific category.
     *
     * @param list existing task list.
     * @param category category to be filtered from the list.
     */
    public void printByCategory(TaskList list, String category) {
        int count = 0;
        for (int i = 0; i < list.sizeOfTask(); i++) {
            Task task = list.returnTask(i);
            if (task.getCategory().equals(category)) {
                count++;
                printTask(task, count);
            }
        }
        if (count == 0) { // no pending task
            printNoTask();
        }
    }

    /**
     * Prints a single task with a leading number.
     *
     * @param task existing task.
     * @param index leading number.
     */
    public void printTask(Task task, int index) {
        System.out.print("   " + index + ".");
        System.out.println(task.taskToStringFormat());
    }


    /**
     * Prints a task from the task list based on the task index.
     *
     * @param list existing task list.
     * @param index task index.
     */
    public void printByTask(TaskList list, int index) {
        System.out.print("   1.");
        System.out.println(list.returnTask(index).taskToStringFormat());
    }

    /**
     * Prints a message when no search result is returned.
     */
    public void printNoResults() {
        System.out.println("   No results found. Please try another parameter");
    }

    private void printNoTask() {
        System.out.println("   No pending tasks. Try command `view -a` to see all tasks.");
    }

    /**
     * Displays the response when a task is added.
     */
    public void printAddedTask(String task, int num) {
        System.out.println("   Noted. I've added this task:\n   " + task + "\n   Now you have " + num
            + " tasks in the list.");
    }

    /**
     * Displays the response when a category is added.
     */
    public void printAddedCategory(String category, int num) {
        System.out.println("   Noted. I've added this category:\n   " + category + "\n   Now you have " + num
            + " categories in the list.");
    }

    /**
     * Displays the response when a category is deleted.
     */
    public void printDeleteCategory(String category, int num) {
        System.out.println("   Noted. I've removed this category:\n   " + category + "\n   Now you have " + num
            + " categories in the list.");
    }

    /**
     * Displays the response when a category is added.
     */
    public void printTaggedCategory(int taskIndex, String category, int num) {
        System.out.println("   Noted. I've tagged task number "
            + (taskIndex + 1) + " with the specified category:\n   " + category);
    }

    public void printUpdatedTask(String task, int num) {
        System.out.println("   Noted. I've updated this task:\n   " + task + "\n");
    }

    public void bye() {
        print("Bye. Hope to see you again soon!");
    }

    public void printProgress(int noOfCompleted, int totalTasks, String percentage) {
        print(noOfCompleted + " out of " + totalTasks + " tasks are completed. " + "(" + percentage + ")");
    }

    public void printTasks(ArrayList<String> tasks) {
        if (tasks.size() < 1) {
            print("   No matching result.");
        } else {
            print("Matched results are: ");
            int index = 1;
            for (String task : tasks) {
                print("   " + index + ". " + task);
                index += 1;
            }
        }
    }
}
