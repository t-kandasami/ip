public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public void setAsDone() {
        this.isDone = true;
    }

    public void setAsNotDone() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        String output;
        if (isDone) {
            output = "[X] " + description;
        } else {
            output = "[ ] " + description;
        }
        return output;
    }
}
