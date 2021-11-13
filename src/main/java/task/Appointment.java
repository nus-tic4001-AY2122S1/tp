package task;

import constant.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment extends Task {
    private final String type;
    private Date at;
    private String location;

    public Appointment(String description, Date at, String location) {
        super(description);
        type = "A";
        this.location = location;
        this.at = at;
    }

    public String taskToStringFormat() {
        SimpleDateFormat formatter = new SimpleDateFormat(Utils.DATE_TIME_FORMAT);

        return "[" + this.getType() + "]" + "[" + super.getStatusIcon() + "] "
            + super.getDescription() + "," + " at " + formatter.format(this.at) + ". "
            + "Location: " + this.location;
    }

    public String getType() {
        return this.type;
    }

    public String getLocation() {
        return this.location;
    }

    public Date getDate() {
        return this.at;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTime(Date time) {
        this.at = time;
    }
}
