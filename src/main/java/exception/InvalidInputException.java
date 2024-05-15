package exception;

import exception.code.ErrorCode;

public class InvalidInputException extends IllegalArgumentException {

    private final ErrorCode errorCode;

    public InvalidInputException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
