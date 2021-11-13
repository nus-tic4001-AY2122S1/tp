package command;

import exception.ErrorHandler;
import storage.Storage;
import task.Assignment;
import tasklist.TaskList;
import ui.Ui;

import java.util.Date;

public class AssignmentCommand extends Command {
    private final String taskDescription;
    private final Date dueOn;
    private final String marks;
    private final String difficultyLevel;
    private final String progressionLevel;

    public AssignmentCommand(String description, String at, String marks, String difficultyLevel,
                             String progressionLevel) throws ErrorHandler {
        this.taskDescription = description;
        this.dueOn = this.parseDateTime(at);
        this.marks = marks;
        this.difficultyLevel = difficultyLevel;
        this.progressionLevel = progressionLevel;

    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        Assignment addedAssignment =
            new Assignment(this.taskDescription, this.dueOn, this.marks, this.difficultyLevel, this.progressionLevel);
        list.addItem(addedAssignment);

        ui.printAddedTask(addedAssignment.taskToStringFormat(), list.sizeOfTask());
    }
}
