package parser;

import category.Category;
import command.ByeCommand;
import command.Command;
import command.DeleteCommand;
import command.TodoCommand;
import command.ViewCommand;
import command.category.AddCategory;
import command.category.DeleteCategory;
import command.category.TagCategory;
import command.category.ViewCategory;
import constant.CommandKeyWords;
import constant.ErrorMessage;
import exception.ErrorHandler;

public class Parser {
    private String content;
    private String taskNo;
    private final Category category = new Category();

    public Command parse(String input) throws ErrorHandler {
        String[] result = input.split(" ", 2);
        CommandKeyWords commandWord = CommandKeyWords.getEnum(result[0].toUpperCase());

        switch (commandWord) {
        case VIEW:
            return new ViewCommand();
        case TODO:
            if (result.length < 2) {
                throw new ErrorHandler(ErrorMessage.EMPTY_TODO);
            }
            this.content = result[1].trim();
            return new TodoCommand(this.content);
        case DELETE:
            if (result.length < 2) {
                throw new ErrorHandler(ErrorMessage.EMPTY_TASK_NUMBER);
            }
            this.taskNo = result[1].trim();

            return new DeleteCommand(this.taskNo);
        case CATEGORY:
            if (result.length < 2) {
                throw new ErrorHandler(ErrorMessage.INVALID_CATEGORY_COMMAND);
            }
            String[] categoryOption = result[1].split(" ", 2);
            switch (categoryOption[0].toLowerCase().trim()) {
            case "view":
                return new ViewCategory();
            case "add":
                if (categoryOption.length < 2) {
                    throw new ErrorHandler(ErrorMessage.EMPTY_CATEGORY_NUMBER);
                }
                return new AddCategory(categoryOption[1].trim());
            case "delete":
                if (categoryOption.length < 2) {
                    throw new ErrorHandler(ErrorMessage.EMPTY_CATEGORY_NUMBER);
                }
                return new DeleteCategory(categoryOption[1].trim());
            case "tag":
                if (categoryOption.length < 2) {
                    throw new ErrorHandler(ErrorMessage.EMPTY_CATEGORY_NUMBER);
                }
                String[] tagOption = categoryOption[1].split(" ", 2);
                if (tagOption.length < 2) {
                    throw new ErrorHandler(ErrorMessage.INVALID_CATEGORY_TAG);
                }
                return new TagCategory(tagOption[0].trim(), tagOption[1].trim());
            default:
                throw new ErrorHandler(ErrorMessage.INVALID_CATEGORY_COMMAND);
            }
        case BYE:
        default:
            return new ByeCommand();
        }
    }
}
