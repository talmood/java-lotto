package view.input;

import view.input.dto.PurchaseInput;

public interface InputView {

    PurchaseInput inputPurchaseAmount();

    void inputWinningNumbers();

    void inputBonusNumber();
}
