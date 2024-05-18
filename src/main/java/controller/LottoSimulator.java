package controller;

import domain.*;
import view.input.ConsoleInputView;
import view.input.InputView;
import view.input.dto.BonusNumberInput;
import view.input.dto.PurchaseInput;
import view.input.dto.WinningNumbersInput;
import view.output.ConsoleOutputView;
import view.output.OutputView;
import view.output.dto.LottoWinningStatisticsOutput;
import view.output.dto.LottosOutput;
import view.output.dto.PurchaseOutput;

public class LottoSimulator {

    public void run() {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();

        PurchaseInput purchaseInput = inputView.inputPurchaseAmount();
        PurchaseAmount purchaseAmount = purchaseInput.toPurchaseAmount();
        PurchaseCountCalculator purchaseCountCalculator = new PurchaseCountCalculator(purchaseAmount);
        PurchaseCount purchaseCount = purchaseCountCalculator.calculate();
        outputView.viewPurchaseAmount(PurchaseOutput.from(purchaseCount));

        LottosGenerator lottosGenerator = new LottosGenerator(purchaseCount);
        Lottos lottos = lottosGenerator.generate();
        outputView.viewLottos(LottosOutput.from(lottos));

        WinningNumbersInput winningNumbersInput = inputView.inputWinningNumbers();
        WinningNumbers winningNumbers = winningNumbersInput.toWinningNumbers();

        BonusNumberInput bonusNumberInput = inputView.inputBonusNumber();
        BonusNumber bonusNumber = bonusNumberInput.toBonusNumber();

        LottosResultCalculator lottosResultCalculator = new LottosResultCalculator(lottos, winningNumbers, bonusNumber);
        LottoWinnings lottoWinnings = lottosResultCalculator.calculate();
        LottoWinningStatisticsOutput lottoWinningStatisticsOutput = LottoWinningStatisticsOutput.from(lottoWinnings, purchaseAmount);
        outputView.viewWinningStatistics(lottoWinningStatisticsOutput);
    }
}
