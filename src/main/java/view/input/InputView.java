package view.input;

import view.input.dto.*;

public interface InputView {

    PurchaseInput inputPurchaseAmount();

    ManualPurchaseCountInput inputManualPurchaseCount();

    ManualLottoNumbersInput inputManualLottoNumbers(int manualPurchaseCount);

    WinningNumbersInput inputWinningNumbers();

    BonusNumberInput inputBonusNumber();
}
