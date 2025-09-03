public class ToDo extends Task{
    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        if (super.isDone){
            return "[T][X] " + super.toString();
        } else {
            return "[T][ ] " + super.toString();
        }
    }
}
