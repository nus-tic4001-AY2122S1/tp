package command;

import exception.ErrorHandler;
import helpers.DateConverter;
import storage.Storage;
import task.Task;
import tasklist.TaskList;
import ui.Ui;

import java.text.ParseException;

import static category.Category.isCategory;
import static helpers.DateConverter.isValidDate;
import static helpers.StringUtils.convertArrayToString;

/**
 * Search task list based on certain parameters
 */
public class SearchCommand extends Command {
    String searchType = "nil";
    String[] param;
    public SearchCommand(String input) throws ErrorHandler {
        param = input.split(" ");
        if (param.length > 1) {
            if (param[1].toUpperCase().equals("APPOINTMENT") || param[1].toUpperCase().equals("TODO")) {
                searchType = "taskType";
            }
            else if (isValidDate(param[1])) {
                searchType = "date";
            }
            else if(isCategory(convertArrayToString(param, true))) {
                searchType = "category";
            }
        }
    }

    public void execute(TaskList list, Ui ui, Storage storage) throws ParseException, ErrorHandler {
        switch(searchType) {
        case("taskType"):
            ui.printByTaskType(list, param[1].toUpperCase());
            break;
        case("date"):
            ui.printByDate(list, DateConverter.convertStringToDate(param[1]));
            break;
        case("category"):
            ui.printByCategory(list, convertArrayToString(param, true));
            break;
        default:
            searchByDesc(list, ui, convertArrayToString(param, true));
        }
    }


    private void searchByDesc(TaskList list, Ui ui, String input) {
        int count = 0;
        boolean hasTask = false;
        for (int i = 0; i < list.sizeOfTask(); i++) {
            Task task =list.returnTask(i);
            String desc = task.getDescription();
            if(desc.toLowerCase().equals(input) || desc.toLowerCase().contains(input)) {
                hasTask = true;
                count++;
                ui.printTask(task, count);
            }
        }
        if (!hasTask) {
            ui.printNoResults();
        }
    }

}
