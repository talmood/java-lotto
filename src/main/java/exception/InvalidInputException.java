package exception;

import exception.code.ErrorCode;

public class InvalidInputException extends IllegalArgumentException {

    private final ErrorCode errorCode;

    public InvalidInputException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
