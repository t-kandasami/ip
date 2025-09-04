public class Deadline extends Task {
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        if (super.isDone) {
            return "[D][X] " + super.toString() + " (by: " + by + ")";
        } else {
            return "[D][ ] " + super.toString() + " (by: " + by + ")";
        }
    }
}
