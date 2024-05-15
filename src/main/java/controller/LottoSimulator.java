package controller;

import domain.Lottos;
import domain.LottosGenerator;
import domain.PurchaseAmount;
import view.input.ConsoleInputView;
import view.input.InputView;
import view.input.dto.PurchaseInput;
import view.output.ConsoleOutputView;
import view.output.OutputView;
import view.output.dto.PurchaseOutput;

public class LottoSimulator {

    public void run() {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();

        PurchaseInput purchaseInput = inputView.inputPurchaseAmount();
        PurchaseAmount purchaseAmount = purchaseInput.toPurchaseAmount();

        PurchaseOutput purchaseOutput = purchaseAmount.toPurchaseOutput();
        outputView.viewPurchaseAmount(purchaseOutput);

        LottosGenerator lottosGenerator = new LottosGenerator(purchaseAmount);
        Lottos lottos = lottosGenerator.generate()



    }
}
