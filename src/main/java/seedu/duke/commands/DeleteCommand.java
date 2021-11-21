package seedu.duke.commands;


import seedu.duke.project.GtdThought;
import seedu.duke.storage.GtdList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * delete a task from the taskList based on the index.
 */
public class DeleteCommand extends Command {
    public static final String COMMAND_WORD = "delete";
    private List<String> targetIndex;
    // private int[] targetIndex;

    public DeleteCommand(List<String> targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public void execute() {
        if (current.size() == 0) {
            System.out.println("`list` first to get task no. for refering purpose");
            return;
        }

        System.out.println("Deleted:");

        ArrayList<GtdThought> toRemove = new ArrayList<>();
        for (int i = 0; i < targetIndex.size(); i++) {
            GtdThought taskToDelete = current.get(targetIndex.get(i));
            toRemove.add(taskToDelete);
            System.out.print(taskToDelete.getTextRec());
        }

        List<GtdThought> projl0 = master.stream()
                        .filter(t -> t.hasChildren())
                        .collect(Collectors.toList());

        List<GtdThought> projl1 = new ArrayList<>();
        projl0.stream()
                .forEach(t -> t.getChildren().stream()
                        .filter(p -> p.hasChildren())
                        .forEach(p -> projl1.add(p)));

        master.removeAll(toRemove);

        for (var sub : toRemove) {
            projl0.stream().forEach(t -> t.removeSub(sub));
        }

        for (var sub : toRemove) {
            projl1.stream().forEach(t -> t.removeSub(sub));
        }

    }
}








