package command.category;

import category.Category;
import command.Command;
import constant.ErrorMessage;
import exception.ErrorHandler;
import storage.Storage;
import tasklist.TaskList;
import ui.Ui;

/**
 * Deletes a category identified using it's index from the category list.
 */

public class DeleteCategory extends Command {
    protected static Ui ui = new Ui();
    private Category category = new Category();
    private final int categoryIndex;
    private String input;

    public DeleteCategory(String categoryNumber) throws ErrorHandler {
        try {
            this.categoryIndex = Integer.parseInt(categoryNumber) - 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ErrorHandler(ErrorMessage.EMPTY_CATEGORY_NUMBER);
        }
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
        if (this.categoryIndex < 0 || this.categoryIndex >= category.size()) {
            throw new ErrorHandler(ErrorMessage.INVALID_CATEGORY_NUMBER);
        }

        String tagCategory = category.getCategory(this.categoryIndex);
        for (String searchCategory : this.category.getList()) {
            if (searchCategory.contains(tagCategory)) {
                throw new ErrorHandler(ErrorMessage.CATEGORY_STILL_IN_USE);
            }
        }

        category.deleteCategory(this.categoryIndex);
        ui.printDeleteCategory(tagCategory, category.size());
    }
}
