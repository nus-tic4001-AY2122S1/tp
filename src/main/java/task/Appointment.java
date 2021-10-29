package task;

public class Appointment extends Task {
    private final String type;
    private final String at;
    private String location;

    public Appointment(String description, String at, String location) {
        super(description);
        type = "A";
        this.location = location;
        this.at = at;
    }

    public String taskToStringFormat() {
        return "[" + this.getType() + "]" + "[" + super.getStatusIcon() + "] "
                + super.getDescription() + "," + " at " + this.at + ". "
                + "Location: " + this.location;
    }

    public String getType() {
        return this.type;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
