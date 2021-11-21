package seedu.duke.commands;


import seedu.duke.project.Stat;

import java.util.List;

/**
 * Marks a task as done statement based on the index.
 */
public class DoneCommand extends Command {

    public static final String COMMAND_WORD = "done";
    private List<String> targetIndex;

    public DoneCommand(List<String> targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public void execute() {
        if (current.size() == 0) {
            System.out.println("`list` first to get task no. for refering purpose");
            return;
        }

        for (String i : targetIndex) {
            var thought = current.get(i);
            System.out.println("Marking " + thought + " as " + Stat.DONE);
            thought.setStatus(Stat.DONE);
        }
    }
}
