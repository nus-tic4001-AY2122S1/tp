package parser;

import category.Category;
import command.*;
import command.category.AddCategory;
import command.category.DeleteCategory;
import command.category.TagCategory;
import command.category.ViewCategory;
import command.DeleteCommand;

import constant.CommandKeyWords;
import constant.ErrorMessage;

import exception.ErrorHandler;

public class Parser {
    private String content;
    private String taskNo;
    private final Category category = new Category();

    public Command parse(String input) throws ErrorHandler {
        input = input.trim();
        String[] result = input.split(" ", 2);
        CommandKeyWords commandWord = CommandKeyWords.getEnum(result[0].toUpperCase());

        switch (commandWord) {
        case VIEW:
            return new ViewCommand(result);
        case DONE:
            if (result.length < 2) {
                throw new ErrorHandler(ErrorMessage.EMPTY_TASK_NUMBER);
            }
            this.taskNo = result[1].trim();
            return new DoneCommand(this.taskNo);
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
        case APPOINTMENT:
            if (result.length < 2) {
                throw new ErrorHandler(ErrorMessage.EMPTY_APPOINTMENT_DESCRIPTION);
            }
            return this.handleNewAppointment(result[1].trim());

        case SET_LOCATION:
            if (result.length < 2) {
                throw new ErrorHandler(ErrorMessage.EMPTY_TASK_NUMBER);
            }
            String[] inputContent = result[1].split(" ", 2);

            if (inputContent.length < 2) {
                throw new ErrorHandler(ErrorMessage.EMPTY_LOCATION_DESCRIPTION);
            }

            this.taskNo = inputContent[0];
            this.content = inputContent[1];

            return new LocationCommand(this.taskNo, this.content);
        case SET_TIME:
            if (result.length < 2) {
                throw new ErrorHandler(ErrorMessage.EMPTY_TASK_NUMBER);
            }

            return this.handleSetTime(result[1]);
        case SEARCH:
            return new SearchCommand(input);
        case BYE:
        default:
            return new ByeCommand();
        }
    }

    private Command handleNewAppointment(String inputContent) throws ErrorHandler {
        String[] appointmentInput = inputContent.split("/at", 2);
        this.content = appointmentInput[0].trim();

        if (appointmentInput.length < 2) {
            throw new ErrorHandler(ErrorMessage.EMPTY_APPOINTMENT_TIME);
        }
        String[] timeContent = appointmentInput[1].split("/l", 2);

        if (timeContent.length < 2) {
            throw new ErrorHandler(ErrorMessage.EMPTY_APPOINTMENT_LOCATION);
        }

        String at = timeContent[0].trim();
        String location = timeContent[1].trim();

        return new AppointmentCommand(this.content, at, location);
    }

    private Command handleSetTime(String input) throws ErrorHandler {
        String[] inputContent = input.split(" ", 2);

        if (inputContent.length < 2) {
            throw new ErrorHandler(ErrorMessage.EMPTY_TIME_DESCRIPTION);
        }
        this.taskNo = inputContent[0];
        this.content = inputContent[1];

        return new AppointmentTimeCommand(this.taskNo, this.content);
    }
}
