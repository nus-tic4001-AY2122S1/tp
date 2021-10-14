package command;

import constant.ErrorMessage;
import exception.ErrorHandler;
import storage.Storage;
import list.TaskList;
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
        if (taskNumber <= 0 || taskNumber > taskList.getSize()) {
            throw new ErrorHandler("In Command, " + ErrorMessage.INVALID_TASK_NUMBER);
        }
    }
  
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ErrorHandler  {
        throw new ErrorHandler("I'm sorry, but I don't know what that means.");
    }

    public abstract void execute(Storage storage, Ui ui, TaskList taskList) throws ErrorHandler;
}