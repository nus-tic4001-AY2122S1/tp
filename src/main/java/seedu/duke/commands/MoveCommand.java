package seedu.duke.commands;


import seedu.duke.storage.GTDList;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Move a task to a folder.
 */
public class MoveCommand extends Command {

    public static final String COMMAND_WORD = "move";
    private int[] targetIndex;

    private String folderType;

    public MoveCommand(int[] targetIndex, String folderType) {
        this.targetIndex = targetIndex;
        this.folderType = folderType;
    }

    @Override
    public void execute() {
        System.out.println("This is a move command. The target index is " + Arrays.toString(targetIndex)
                + " and target folder is " + folderType.toString());
    }
}
