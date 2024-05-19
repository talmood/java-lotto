package view;

import model.LottoPurchaseAmount;

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

}
