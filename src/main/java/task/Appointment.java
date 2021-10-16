package task;

public class Appointment extends Task {
    private final String type;
    private String location;

    public Appointment(String description) {
        super(description);
        type = "A";
    }

    public String taskToStringFormat() {
        return "[" + this.getType() + "]" + "[" + super.getStatusIcon() + "] " + super.getDescription();
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
