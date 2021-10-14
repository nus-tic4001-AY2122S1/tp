package command;

import exception.ErrorHandler;
import storage.Storage;
import tasklist.TaskList;
import ui.Ui;

/**
 * Deletes a task identified using it's index from the task list.
 */

public class DeleteCommand extends Command {
    //    protected static Ui ui = new Ui();
//    private String input;
    private final int taskIndex;

    public DeleteCommand(String taskNumber) throws ErrorHandler {
        this.taskIndex = this.parseTaskNumberToIndex(taskNumber);
    }

    /**
     * Executes the command.
     *
     * @param list    The tasks stored in an ArrayList.
     * @param ui      The User Interface (UI).
     * @param storage The storage to allow reading and storing of tasks from and to a txt file.
     */
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) throws ErrorHandler {
//        input = input.toLowerCase();
//        int num = 0;
//        if (input.matches(".*\\d.*")) {
//            num = Integer.parseInt(input.replaceAll("[\\D]", ""));
//        }
//        if (num > 0 && num <= list.sizeOfTask()) {
//            Task echo = list.returnTask(num - 1);
//            list.deleteTask(num - 1);
//            ui.printDeleteCommand(echo, list.sizeOfTask());
//        } else {
//            throw new ErrorHandler("Item not found.\n");
//        }
//        ui.printEmptyLine();

        this.checkTaskNumberOutOfRange(this.taskIndex, list);

        String deletedItem = list.returnTask(this.taskIndex).taskToStringFormat();

        list.deleteTask(this.taskIndex);
        ui.printDeleteCommand(deletedItem, list.sizeOfTask());
    }

}
