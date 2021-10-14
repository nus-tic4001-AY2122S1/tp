package command;

import constant.ErrorMessage;
import exception.ErrorHandler;
import storage.Storage;
import ui.Ui;
import tasklist.TaskList;

/**
 * Represents an executable command.
 */
public abstract class Command {
    protected static Ui ui = new Ui();
    protected boolean isExist = false;

    public boolean getIsExist() {
        return this.isExist;
    }

    protected int parseTaskNumber(String taskNumber) throws ErrorHandler {
        try {
            return Integer.parseInt(taskNumber);
        } catch (Exception e) {
            throw new ErrorHandler(ErrorMessage.INVALID_TASK_NUMBER);
        }
    }

    protected void checkTaskNumberOutOfRange(int taskNumber, TaskList taskList) throws ErrorHandler {
        if (taskNumber <= 0 || taskNumber > taskList.sizeOfTask()) {
            throw new ErrorHandler("In Command, " + ErrorMessage.INVALID_TASK_NUMBER);
        }
    }
  
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws ErrorHandler;
}