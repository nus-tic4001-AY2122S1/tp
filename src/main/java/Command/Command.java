package Command;

import constant.ErrorMessage;
import exception.ErrorHandler;
import storage.Storage;
import taskList.TaskList;
import ui.Ui;

public abstract class Command {
    protected boolean isExit = false;

    protected int pareTaskNumber(String taskNumber)throws ErrorHandler {
        try {
            return Integer.parseInt(taskNumber);
        } catch (Exception e) {
            throw new ErrorHandler(ErrorMessage.INVALID_TASK_NUMBER);
        }
    }

    protected void checkTaskNumberOutOfRange(int taskNumber, TaskList taskList)throws ErrorHandler {
        if (taskNumber <= 0 || taskNumber > taskList.getSize())
            throw new ErrorHandler("In Command, " + ErrorMessage.INVALID_TASK_NUMBER);
    }

    public abstract void execute (Storage storage, Ui ui, TaskList taskList) throws ErrorHandler;
}

