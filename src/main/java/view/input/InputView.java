package view.input;

import view.input.dto.PurchaseInput;
import view.input.dto.WinningNumbersInput;

public interface InputView {

    PurchaseInput inputPurchaseAmount();

    WinningNumbersInput inputWinningNumbers();

    void inputBonusNumber();
}
