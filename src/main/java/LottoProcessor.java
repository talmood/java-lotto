public class LottoProcessor {

    private final InputView inputView;

    private final ResultView resultView;

    public LottoProcessor(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void processGame() {
        //구매 금액을 입력받는다.
        int price = acceptPriceForLottoGame();

    }

    private int acceptPriceForLottoGame() {
        inputView.guidePurchasePrice();
        Integer price;

        do {
            String stringInput = inputView.acceptInput();
            price = inputView.validatePurchasePrice(stringInput);
        } while (price == null);

        return price;
    }
}
