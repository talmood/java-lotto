package view.output;

import view.output.dto.PurchaseOutput;

public class ConsoleOutputView implements OutputView{

    private static final String PURCHASE_COUNT_NAVIGATION = "%d개를 구매했습니다.";

    @Override
    public void viewPurchaseAmount(PurchaseOutput purchaseOutput) {
        System.out.printf((PURCHASE_COUNT_NAVIGATION) + "%n", purchaseOutput.fetchPurchaseCount());
    }

    @Override
    public void viewLotto() {

    }

    @Override
    public void viewWinningResult() {

    }
}
