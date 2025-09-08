package prime.exceptions;

public class EmptyToException extends PrimeException {
    public EmptyToException(int index) {
        super("OOPS!!! The Task Number " + index + " is invalid.");
    }
}
