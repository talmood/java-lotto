package view.input.dto;

import domain.BonusNumber;

public class BonusNumberInput {

    private final int bonusNumber;

    public BonusNumberInput(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public BonusNumber toBonusNumber() {
        return BonusNumber.create(this.bonusNumber);
    }
}
