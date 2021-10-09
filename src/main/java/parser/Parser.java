package parser;

import command.Command;
import command.LocationCommand;
import command.DummyCommand;
import constant.CommandKeyWords;
import constant.ErrorMessage;
import exception.ErrorHandler;

public class Parser {
    private String content;
    private String taskNo;

    public Command parse(String input) throws ErrorHandler {
        String[] result = input.split(" ", 3);
        CommandKeyWords commandWord = CommandKeyWords.getEnum(result[0].toUpperCase());

        switch (commandWord) {
            case LOCATION:
                if (result.length < 2) {
                    throw new ErrorHandler(ErrorMessage.EMPTY_TASK_NUMBER);
                }
                this.taskNo = result[1].trim();

                if (result.length < 3) {
                    throw new ErrorHandler(ErrorMessage.EMPTY_LOCATION_DESCRIPTION);
                }
                this.content = result[2].trim();

                return new LocationCommand(this.taskNo, this.content);
            default:
                return new DummyCommand();
        }
    }
}
