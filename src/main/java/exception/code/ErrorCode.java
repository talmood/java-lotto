package exception.code;

public enum ErrorCode {

    ONLY_NUMBER_INPUT("숫자인 입력값만 허용됩니다."),
    PURCHASE_COUNT_BIGGER_THAN_ZERO("구입 갯수는 1개이상이어야 합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
