package parser;

import command.ByeCommand;
import command.Command;
import command.DeleteCommand;
import command.TodoCommand;
import command.ViewCommand;
import command.LocationCommand;
import constant.CommandKeyWords;
import constant.ErrorMessage;
import exception.ErrorHandler;

public class Parser {
    private String content;
    private String taskNo;

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
            case BYE:
            default:
                return new ByeCommand();
        }
    }
}
