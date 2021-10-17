package seedu.duke.commands;


import seedu.duke.project.GtdThought;
import seedu.duke.project.Stat;

import java.util.Arrays;
import java.util.List;


/**
 * delete a task from the taskList based on the index.
 */
public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";
    private int[] targetIndex;

    public DeleteCommand(int[] targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public void execute() {
        master.remove(targetIndex, current.getList());
        System.out.println("This is a delete command, the target index is " + Arrays.toString(targetIndex));
    }
}








