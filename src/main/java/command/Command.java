package command;

import constant.ErrorMessage;
import constant.Utils;
import exception.ErrorHandler;
import storage.Storage;
import tasklist.TaskList;
import ui.Ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents an executable command.
 */
public abstract class Command {
    protected boolean isExit = false;

    public boolean isExiting() {
        return this.isExit;
    }

    protected int parseTaskNumberToIndex(String taskNumber) throws ErrorHandler {
        try {
            // for user input it will start from 1, we need to minus 1 for list index.
            return Integer.parseInt(taskNumber) - 1;
        } catch (Exception e) {
            throw new ErrorHandler(ErrorMessage.INVALID_TASK_NUMBER);
        }
    }

    protected void checkTaskNumberOutOfRange(int taskNumber, TaskList taskList) throws ErrorHandler {
        if (taskNumber < 0 || taskNumber >= taskList.sizeOfTask()) {
            throw new ErrorHandler(ErrorMessage.INVALID_TASK_NUMBER);
        }
    }

    protected Date parseDateTime(String time) throws ErrorHandler {
        SimpleDateFormat formatter = new SimpleDateFormat(Utils.DATE_TIME_FORMAT);

        try {
            return formatter.parse(time);
        } catch (ParseException e) {
            throw new ErrorHandler(ErrorMessage.INVALID_APPOINTMENT_TIME);
        }
    }

    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws ErrorHandler;
}