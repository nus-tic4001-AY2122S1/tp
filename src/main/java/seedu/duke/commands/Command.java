package seedu.duke.commands;

import seedu.duke.exception.InvalidListArgumentException;
import seedu.duke.storage.GtdList;

import java.util.ArrayList;
import java.util.Hashtable;

public class Command {

    protected GtdList master;
    protected GtdList current;
    //protected GtdList allList;

    public Command() {

    }

    public void execute() throws InvalidListArgumentException {
    }

    /**
     * Supplies the data the command will operate on.
     */
    public void setData(ArrayList<GtdList> lists) {
        this.master = lists.get(0);
        this.current = lists.get(1);
        //this.allList = lists.get(2);

    }
}
