package controller;

import domain.PurchaseAmount;
import view.ConsoleInputView;
import view.InputView;
import view.dto.PurchaseInput;

public class LottoSimulator {

    public void run() {
        InputView inputView = new ConsoleInputView();
        PurchaseInput purchaseInput = inputView.inputPurchaseAmount();
        PurchaseAmount purchaseAmount = purchaseInput.toPurchaseAmount();

    }
}
