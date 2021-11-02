package command.category;

import category.Category;
import command.Command;
import constant.ErrorMessage;
import exception.ErrorHandler;
import storage.Storage;
import tasklist.TaskList;
import ui.Ui;

public class TagCategory extends Command {
    private final String categoryName;
    private final int taskNum;
    private Category category = new Category();

    public TagCategory(String taskNum, String categoryName) throws ErrorHandler {
        if (categoryName.isEmpty() || categoryName.isBlank()) {
            throw new ErrorHandler(ErrorMessage.EMPTY_CATEGORY_NAME);
        }

        this.categoryName = categoryName;
        this.taskNum = this.parseTaskNumberToIndex(taskNum);

        boolean categoryExists = false;
        for (String searchCategory : this.category.getList()) {
            if (searchCategory.contains(categoryName)) {
                categoryExists = true;
            }
        }

        if (!categoryExists) {
            throw new ErrorHandler(ErrorMessage.CATEGORY_DOES_NOT_EXIST);
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ErrorHandler {
        this.checkTaskNumberOutOfRange(this.taskNum, tasks);
        tasks.tagItem(tasks.returnTask(this.taskNum), this.categoryName);
        ui.printTaggedCategory(taskNum, this.categoryName, category.size());
    }
}
