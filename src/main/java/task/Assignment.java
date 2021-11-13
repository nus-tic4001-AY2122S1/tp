package task;

import constant.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Assignment extends Task {
    private final String type;
    private Date dueOn;
    private String marks;
    private String difficultyLevel;
    private String progressionLevel;

    public Assignment(String description, Date dueOn, String marks, String difficultyLevel, String progressionLevel) {
        super(description);
        type = "100";
        this.marks = marks;
        this.dueOn = dueOn;
        this.difficultyLevel = difficultyLevel;
        this.progressionLevel = progressionLevel;
    }

    public String taskToStringFormat() {
        SimpleDateFormat formatter = new SimpleDateFormat(Utils.DATE_TIME_FORMAT);

        return "[" + this.getType() + "]" + "[" + super.getStatusIcon() + "] "
            + super.getDescription() + "," + " due on " + formatter.format(this.dueOn) + ". "
            + "Marks: " + this.marks + ". "
            + "difficultyLevel: " + this.difficultyLevel + ". "
            + "progressionLevel: " + this.progressionLevel;
    }

    public String getType() {
        return this.type;
    }

    public void setProgressionLevel(String progression) {
        this.progressionLevel = progression;
    }

    public void setTime(Date time) {
        this.dueOn = time;
    }
}
