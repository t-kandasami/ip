package prime.exceptions;

public class InvalidTaskNumberException extends PrimeException {
    public InvalidTaskNumberException(int taskNo, int max) {
        super("Invalid task number of " + taskNo + "! Please try again." +
                "\n    You are allowed to enter a number between 1 and " + max);
    }
}
