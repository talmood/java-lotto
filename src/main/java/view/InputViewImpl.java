package view;

import model.LottoBonusNumber;
import model.LottoPurchaseAmount;
import model.LottoWinningGame;

public class InputViewImpl implements InputView {

    private final InputReader inputReader;
    private final OutputWriter outputWriter;

    public InputViewImpl(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }

    @Override
    public LottoPurchaseAmount inputLottoPurchaseAmount() {
        outputWriter.writeMessage("구입금액을 입력해 주세요.");
        String amountInput = inputReader.readInputMessage();
        return InputLottoPurchaseAmount.fromAmountString(amountInput).toLottoPurchaseAmount();
    }

    @Override
    public LottoWinningGame inputLottoWinningGame() {
        outputWriter.writeMessage("지난 주 당첨 번호를 입력해 주세요.");
        final String winningGame = inputReader.readInputMessage();
        return InputLottoWinningGame.fromNumberLiterals(winningGame).toLottoWinningGame();
    }

    @Override
    public LottoBonusNumber inputLottoBonusNumber() {
        outputWriter.writeMessage("보너스 볼을 입력해 주세요.");
        final String bonusNumber = inputReader.readInputMessage();
        return InputLottoBonusNumber.fromNumberLiteral(bonusNumber).toLottoBonusNumber();
    }

}
