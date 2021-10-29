package command.category;

import category.Category;
import command.Command;
import constant.ErrorMessage;
import exception.ErrorHandler;
import storage.Storage;
import tasklist.TaskList;
import ui.Ui;

public class AddCategory extends Command {
    private final String categoryName;
    private Category category = new Category();

    public AddCategory(String category) throws ErrorHandler {
        if (category.isEmpty() || category.isBlank()) {
            throw new ErrorHandler(ErrorMessage.EMPTY_CATEGORY_NAME);
        }
        this.categoryName = category;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        category.addCategory(this.categoryName);
        ui.printAddedCategory(this.categoryName, category.size());
    }
}
