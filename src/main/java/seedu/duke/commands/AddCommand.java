package seedu.duke.commands;


import seedu.duke.project.GTDThought;
import seedu.duke.storage.GTDList;

import java.util.ArrayList;

public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    private String taskname;


    public AddCommand(String taskname) {
        this.taskname = taskname;
    }

    @Override
    public void execute() {
        System.out.println("This is an add command, the added task is " + taskname);
        GTDLists.get(0).add(new GTDThought(taskname));
    }


}
