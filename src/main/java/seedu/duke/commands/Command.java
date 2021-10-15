package seedu.duke.commands;

import seedu.duke.exception.InvalidListArgumentException;
import seedu.duke.storage.GtdList;

import java.util.Hashtable;

public class Command {

    protected Hashtable<String, GtdList> GTDLists;

    public Command() {

    }

    public void execute() throws InvalidListArgumentException {
    }

    /**
     * Supplies the data the command will operate on.
     */
    public void setData(Hashtable<String, GtdList> GTDLists) {
        this.GTDLists = GTDLists;
    }
}
