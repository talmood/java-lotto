package exception;

import exception.code.ErrorCode;

public class InvalidOutputException extends IllegalArgumentException {

    private final ErrorCode errorCode;

    public InvalidOutputException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
