package controller;

import domain.PurchaseAmount;
import view.input.ConsoleInputView;
import view.input.InputView;
import view.input.dto.PurchaseInput;
import view.output.dto.PurchaseOutput;

public class LottoSimulator {

    public void run() {
        InputView inputView = new ConsoleInputView();
        PurchaseInput purchaseInput = inputView.inputPurchaseAmount();
        PurchaseAmount purchaseAmount = purchaseInput.toPurchaseAmount();
        PurchaseOutput purchaseOutput = purchaseAmount.toPurchaseOutput();


    }
}
