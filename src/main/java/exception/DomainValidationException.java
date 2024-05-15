package exception;

import exception.code.ErrorCode;

public class DomainValidationException extends IllegalArgumentException {

    private final ErrorCode errorCode;

    public DomainValidationException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
