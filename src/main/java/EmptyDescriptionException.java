public class EmptyDescriptionException extends PrimeException {
    public EmptyDescriptionException(CommandType commandType) {
        super("OOPS!!! The description of " + commandType.toString() + " cannot be empty.");
    }
}
