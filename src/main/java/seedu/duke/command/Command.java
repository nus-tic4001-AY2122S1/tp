package seedu.duke.command;

import seedu.duke.ItemList;
import seedu.duke.InputErrorException;

import java.text.ParseException;

public abstract class Command {
    protected String command;

    public Command(String command) {
        this.command = command;
    }

    public abstract void run(ItemList itemList) throws ParseException, InputErrorException;
}
