package task;

public class Todo extends Task {
    private String type;

    public Todo(String description) {
        super(description);
        type = "T";
    }

    @Override
    public String taskToStringFormat() {
        return "[" + this.getType() + "]" +  "[" + super.getStatusIcon() + "] " + super.getDescription();
    }

    @Override
    public String getType() {
        return type;
    }
}