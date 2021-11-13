package parser;

import category.Category;
import command.*;
import command.category.AddCategory;
import command.category.DeleteCategory;
import command.category.TagCategory;
import command.category.ViewCategory;

import constant.CommandKeyWords;
import constant.ErrorMessage;

import exception.ErrorHandler;

public class Parser {
    private final Category category = new Category();
    private String content;
    private String taskNo;

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

            if (result.length < 2) {
                throw new ErrorHandler(ErrorMessage.EMPTY_SEARCH_CATEGORY);
            }

            return this.handleSearch(result[1]);
            
        case HOMEWORK:
            if (result.length < 2) {
                throw new ErrorHandler(ErrorMessage.EMPTY_ASSIGNMENT_DESCRIPTION);
            }
            return this.handleNewAssignment(result[1].trim());

        case CHANGE:
            if (result.length < 2) {
                throw new ErrorHandler(ErrorMessage.EMPTY_TASK_NUMBER);
            }
            String[] inputProgression = result[1].split(" ", 2);

            if (inputProgression.length < 2) {
                throw new ErrorHandler(ErrorMessage.EMPTY_SET_PROGRESSION);
            }

            this.taskNo = inputProgression[0];
            this.content = inputProgression[1];

            return new ProgressionCommand(this.taskNo, this.content);

        case TIMEFRAME:
            if (result.length < 2) {
                throw new ErrorHandler(ErrorMessage.EMPTY_TASK_NUMBER);
            }

            return this.handleDeadLine(result[1]);

        case PROGRESS:
            return new TaskProgressCommand();

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

    private Command handleSearch(String input) throws ErrorHandler {
        String[] result = input.split(" ", 2);

        if (result.length < 2) {
            throw new ErrorHandler(ErrorMessage.MISSING_SEARCHING_DESCRIPTION);
        }

        String searchCategory = result[0].trim();

        if (searchCategory.equals("--date")) {
            return new SearchByDateCommand(result[1]);
        } else {
            throw new ErrorHandler(ErrorMessage.INVALID_SEARCH_CATEGORY);
        }
    }
  
    private Command handleDeadLine(String input) throws ErrorHandler {
        String[] inputContent = input.split(" ", 2);

        if (inputContent.length < 2) {
            throw new ErrorHandler(ErrorMessage.EMPTY_TIME_DESCRIPTION);
        }
        this.taskNo = inputContent[0];
        this.content = inputContent[1];

        return new DueDateCommand(this.taskNo, this.content);
    }

    private Command handleNewAssignment(String inputContent) throws ErrorHandler {
        String[] assignmentInput = inputContent.split("/due_on", 2);
        this.content = assignmentInput[0].trim();

        if (assignmentInput.length < 2) {
            throw new ErrorHandler(ErrorMessage.EMPTY_ASSIGNMENT_MARKS);
        }
        String[] timeContent = assignmentInput[1].split("/l", 2);

        if (timeContent.length < 2) {
            throw new ErrorHandler(ErrorMessage.EMPTY_ASSIGNMENT_DUE_DATE);
        }

        String[] difficultyContent = timeContent[1].split("/D", 2);

        if (difficultyContent.length < 2) {
            throw new ErrorHandler(ErrorMessage.EMPTY_DIFFICULTY_LEVEL);
        }

        String[] progressionContent = difficultyContent[1].split("/P", 2);

        if (progressionContent.length < 2) {
            throw new ErrorHandler(ErrorMessage.EMPTY_PROGRESSION_LEVEL);
        }

        String dueOn = timeContent[0].trim();
        String marks = difficultyContent[0].trim();
        String difficulty = progressionContent[0].trim();
        String progression = progressionContent[1].trim();

        return new AssignmentCommand(this.content, dueOn, marks, difficulty, progression);
    }

}
