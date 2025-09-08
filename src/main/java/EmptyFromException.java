public class EmptyFromException extends PrimeException {
    public EmptyFromException(CommandType commandType) {
        super("OOPS!!! The Task Number " + commandType.toString() + " is invalid.");
    }
}
