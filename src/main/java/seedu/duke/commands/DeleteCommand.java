package seedu.duke.commands;


import java.util.Arrays;


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
        for (int i : targetIndex) {
            master.remove(i - 1);
        }
        System.out.println("This is a delete command, the target index is " + Arrays.toString(targetIndex));
    }
}








