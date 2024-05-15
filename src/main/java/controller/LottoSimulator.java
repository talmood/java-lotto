package controller;

import domain.PurchaseAmount;
import view.input.ConsoleInputView;
import view.input.InputView;
import view.input.dto.PurchaseInput;

public class LottoSimulator {

    public void run() {
        InputView inputView = new ConsoleInputView();
        PurchaseInput purchaseInput = inputView.inputPurchaseAmount();
        PurchaseAmount purchaseAmount = purchaseInput.toPurchaseAmount();


    }
}
