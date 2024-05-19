package model;

public record LottoNumber(
        int number
) {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public LottoNumber {
        if (number > MAX_NUMBER || number < MIN_NUMBER) {
            throw new IllegalArgumentException("로또 숫자는 1 이상 45 이하여야합니다.");
        }
    }

}
