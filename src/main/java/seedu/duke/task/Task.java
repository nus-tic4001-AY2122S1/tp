package seedu.duke.task;

import seedu.duke.task.TaskList;

import java.util.ArrayList;
import java.util.List;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markAsDone() {
        isDone = true;
    }

    public List<String> getList() {
        return List.of(isDone ? "1" : "0", description);
    }
}
