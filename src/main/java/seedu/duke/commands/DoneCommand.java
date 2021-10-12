package seedu.duke.commands;


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
    public void execute() {
        System.out.println("This is a done command, the target index is " + Arrays.toString(targetIndex));

    }
}
