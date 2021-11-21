package seedu.duke.commands;


import seedu.duke.project.Stat;

import java.util.List;

/**
 * Set a task from inbox to a folder. // For v1 at least.
 */
public class SetCommand extends Command {

    public static final String COMMAND_WORD = "set";
    private List<String> targetIndex;
    private String folderType;
    private Stat stat;

    public SetCommand(List<String> targetIndex, String folderType) {
        this.targetIndex = targetIndex;
        this.folderType = folderType.toUpperCase(); //enum is all in uppercase.

    }

    @Override
    public void execute() {
        if (current.size() == 0) {
            System.out.println("`list` first to get task no. for refering purpose");
            return;
        }
        if (folderType.equalsIgnoreCase("inbox")) {
            stat = Stat.NONE;
            for (String i : targetIndex) {
                var thought = current.get(i);
                thought.setStatus(stat);
                thought.setlevel(0);
                master.add(thought);
                thought.getParent().get().removeSub(thought);
                System.out.println("Mark " + thought + " as " + stat);
            }

        } else {
            stat = Stat.valueOf(folderType);
            for (String i : targetIndex) {
                var thought = current.get(i);
                System.out.println("Mark " + thought + " as " + stat);
                thought.setStatus(stat);
            }
        }
    }
}
