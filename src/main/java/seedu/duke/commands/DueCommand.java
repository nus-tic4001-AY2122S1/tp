package seedu.duke.commands;

import java.util.List;
import java.time.LocalDate;

public class DueCommand extends Command {
    public static final String COMMAND_WORD = "due";
    private List<String> targetIndex;
    private LocalDate due;

    public DueCommand(List<String> targetIndex, LocalDate due) {
        this.targetIndex = targetIndex;
        this.due = due;
    }

    @Override
    public void execute() {
        if (current.size() == 0) {
            System.out.println("`list` first to get task no. for refering purpose");
            return;
        }

        for (String i : targetIndex) {
            var thought = current.get(i);
            System.out.println("Setting due date of " + thought + " to " + due.toString());
            thought.setDue(due);
        }
    }
}
