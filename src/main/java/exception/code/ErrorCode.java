package exception.code;

public enum ErrorCode {

    ONLY_NUMBER_INPUT("숫자인 입력값만 허용됩니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
