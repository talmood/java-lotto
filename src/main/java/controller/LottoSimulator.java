package controller;

import domain.*;
import view.input.ConsoleInputView;
import view.input.InputView;
import view.input.dto.*;
import view.output.ConsoleOutputView;
import view.output.OutputView;
import view.output.dto.LottoWinningStatisticsOutput;
import view.output.dto.LottosOutput;
import view.output.dto.PurchaseCountOutput;

public class LottoSimulator {

    public void run() {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();

        PurchaseInput purchaseInput = inputView.inputPurchaseAmount();
        PurchaseAmount purchaseAmount = purchaseInput.toPurchaseAmount();

        ManualPurchaseCountInput manualPurchaseCountInput = inputView.inputManualPurchaseCount();
        PurchaseCount manualPurchaseCount = manualPurchaseCountInput.toManualPurchaseCount();
        ManualLottoNumbersInput manualLottoNumbersInput = inputView.inputManualLottoNumbers(manualPurchaseCount.fetchPurchaseCount());
        PurchaseCountCalculator purchaseCountCalculator = new PurchaseCountCalculator(purchaseAmount);
        PurchaseCount autoPurchaseCount = purchaseCountCalculator.calculateAutoPurchaseCount(manualPurchaseCount);
        outputView.viewPurchaseCount(PurchaseCountOutput.of(manualPurchaseCount, autoPurchaseCount));

        LottosGenerator lottosGenerator = new LottosGenerator(autoPurchaseCount);
        Lottos manualLottos = manualLottoNumbersInput.toLottos();
        Lottos autoLottos = lottosGenerator.generate();
        Lottos lottos = manualLottos.addLottos(autoLottos);
        outputView.viewLottos(LottosOutput.from(lottos));

        WinningNumbersInput winningNumbersInput = inputView.inputWinningNumbers();
        WinningNumbers winningNumbers = winningNumbersInput.toWinningNumbers();

        BonusNumberInput bonusNumberInput = inputView.inputBonusNumber();
        BonusNumber bonusNumber = bonusNumberInput.toBonusNumber();

        LottosWinningCalculator lottosWinningCalculator = new LottosWinningCalculator(lottos, winningNumbers, bonusNumber);
        LottoWinnings lottoWinnings = lottosWinningCalculator.calculate();
        LottoWinningStatisticsOutput lottoWinningStatisticsOutput = LottoWinningStatisticsOutput.from(lottoWinnings, purchaseAmount);
        outputView.viewWinningStatistics(lottoWinningStatisticsOutput);
    }
}
