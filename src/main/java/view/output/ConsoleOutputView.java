package view.output;

import view.output.dto.LottosOutput;
import view.output.dto.PurchaseOutput;

public class ConsoleOutputView implements OutputView{

    private static final String PURCHASE_COUNT_NAVIGATION = "%d개를 구매했습니다.";

    @Override
    public void viewPurchaseAmount(PurchaseOutput purchaseOutput) {
        System.out.printf((PURCHASE_COUNT_NAVIGATION) + "%n", purchaseOutput.fetchPurchaseCount());
    }

    @Override
    public void viewLottos(LottosOutput lottosOutput) {
        System.out.println(lottosOutput.fetchLottosNumbersStr());
    }

    @Override
    public void viewWinningResult() {

    }
}
