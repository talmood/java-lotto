package domain;

public class BonusNumber {

    private final int bonusNumber;

    private BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber create(int bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    public int fetchBonusNumber() {
        return this.bonusNumber;
    }

    public boolean isSameNumber(int number) {
        return this.bonusNumber == number;
    }


}
