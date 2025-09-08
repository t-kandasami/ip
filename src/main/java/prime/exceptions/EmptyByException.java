package prime.exceptions;

import prime.parser.CommandType;

public class EmptyByException extends PrimeException {
    public EmptyByException(CommandType commandType) {
        super("OOPS!!! The Task Number " + commandType.toString() + " is invalid.");
    }
}
