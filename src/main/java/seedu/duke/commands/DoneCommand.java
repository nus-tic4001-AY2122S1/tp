package seedu.duke.commands;


import seedu.duke.project.Stat;

import java.util.Arrays;

/**
 * Marks a task as done statement based on the index.
 */
public class DoneCommand extends Command {

    public static final String COMMAND_WORD = "done";
    private int[] targetIndex;

    public DoneCommand(int[] targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public void execute() {;
        var inbox = this.GTDLists.get("inbox");
        for (int i : targetIndex) {
            var thought = inbox.get(i);
            System.out.println("Marking " + thought + " as " + Stat.DONE);
            thought.setStatus(Stat.DONE);
        }
    }
}
