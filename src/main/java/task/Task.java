package task;

public abstract class Task {
    private String description;
    private String category;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.category = "";
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Boolean status) {
        isDone = status;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {  return category; }

    public Boolean getStatus() {
        return isDone;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public abstract String taskToStringFormat();

    public abstract String getType();
}