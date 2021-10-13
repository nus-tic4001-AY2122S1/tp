package seedu.duke.commands;


import seedu.duke.storage.GTDList;

import java.util.ArrayList;

/**
 * Represents an incorrect command. Upon execution, produces some feedback to the user.
 */
public class IncorrectCommand extends Command {

    public final String feedbackToUser;

    public IncorrectCommand(String feedbackToUser) {
        this.feedbackToUser = feedbackToUser;
    }

    @Override
    public void execute(ArrayList<GTDList> folders) {
       System.out.println(feedbackToUser);
    }
}
