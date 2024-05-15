package view.output;

import view.output.dto.PurchaseOutput;

public interface OutputView {

    void viewPurchaseAmount(PurchaseOutput purchaseOutput);

    void viewLotto();

    void viewWinningResult();
}
