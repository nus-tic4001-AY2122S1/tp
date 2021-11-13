package command;

import constant.ErrorMessage;
import constant.Utils;
import exception.ErrorHandler;
import helpers.DateConverter;
import storage.Storage;
import tasklist.TaskList;
import ui.Ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    protected java.util.Date parseDateTime(String dateTime) throws ErrorHandler {
        String[] dayTime = dateTime.split(" ", 2);
        if (dayTime.length < 2) {
            throw new ErrorHandler(ErrorMessage.INVALID_APPOINTMENT_TIME);
        }

        String time = dayTime[1];
        String day = DateConverter.convert(dayTime[0]).trim();

        SimpleDateFormat formatter = new SimpleDateFormat(Utils.DATE_TIME_FORMAT);

        try {
            return formatter.parse(day + " " + time);
        } catch (ParseException e) {
            throw new ErrorHandler(ErrorMessage.INVALID_APPOINTMENT_TIME);
        }
    }

    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws ErrorHandler, ParseException;

    protected Date parseDate(String date) throws ErrorHandler {
        String day = DateConverter.convert(date).trim();
        SimpleDateFormat formatter = new SimpleDateFormat(Utils.DATE_FORMAT);

        try {
            return formatter.parse(day);
        } catch (ParseException e) {
            throw new ErrorHandler(ErrorMessage.INVALID_DATE_FORMAT);
        }
    }

    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws ErrorHandler;

}