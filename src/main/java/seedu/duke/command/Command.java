package seedu.duke.command;

import seedu.duke.ItemList;
import seedu.duke.InputErrorException;

import java.text.ParseException;

public abstract class Command {
    protected String fullCommand;

    public Command(String fullCommand) {
        this.fullCommand = fullCommand;
    }

    public abstract void run(ItemList itemList) throws ParseException, InputErrorException;
}
