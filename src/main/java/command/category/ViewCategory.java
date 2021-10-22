package command.category;

import category.Category;
import command.Command;
import exception.ErrorHandler;
import ui.Ui;
import storage.Storage;
import tasklist.TaskList;

/**
 * Lists all categories in the category list to the user.
 */
public class ViewCategory extends Command {
    protected static Ui ui = new Ui();
    private Category category = new Category();

    /**
     * Executes the command.
     *
     * @param list    The tasks stored in an ArrayList.
     * @param ui      The User Interface (UI).
     * @param storage The storage to allow reading and storing of tasks from and to a txt file.
     */
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) throws ErrorHandler {
        if (category.size() == 0) {
            throw new ErrorHandler("The category list is empty.");
        }
        ui.printCategoryList(category);
    }

}