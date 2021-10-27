package seedu.duke.commands;


import seedu.duke.project.Stat;

/**
 * Set a task from inbox to a folder. // For v1 at least.
 */
public class SetCommand extends Command {

    public static final String COMMAND_WORD = "set";
    private int[] targetIndex;

    private String folderType;

    public SetCommand(int[] targetIndex, String folderType) {
        this.targetIndex = targetIndex;
        this.folderType = folderType.toUpperCase(); //enum is all in uppercase.

    }

    @Override
    public void execute() {
        Stat stat = Stat.valueOf(folderType);
        for (int i : targetIndex) {
            var thought = current.get(i - 1);
            System.out.println("Moving " + thought + " to " + stat);
            thought.setStatus(stat);
        }
    }
}
