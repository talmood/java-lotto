package exception;

import exception.code.ErrorCode;

public class DomainValidationException extends IllegalArgumentException {

    private final ErrorCode errorCode;

    public DomainValidationException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode fetchErrorCode() {
        return this.errorCode;
    }
}
