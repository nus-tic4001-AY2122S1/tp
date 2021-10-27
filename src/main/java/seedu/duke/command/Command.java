package seedu.duke.command;

import seedu.duke.itemList;
import seedu.duke.InputErrorException;

import java.text.ParseException;

public abstract class Command {
    protected String command;

    public Command(String command) {
        this.command = command;
    }

    public abstract void run(itemList itemList) throws ParseException, InputErrorException;
}
