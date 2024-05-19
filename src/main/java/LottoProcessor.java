public class LottoProcessor {

    private final InputView inputView;

    private final ResultView resultView;

    public LottoProcessor(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void processGame() {
        //구매 금액을 입력받는다.
        Integer price = acceptPriceForLottoGame();

        Integer gameCount = decideGameCount(price);
        resultView.printPurchasedGameCount(gameCount);


    }

    private Integer decideGameCount(Integer price) {
        GameCountDecider gameCountDecider = new GameCountDecider();
        return gameCountDecider.calculateGameForPrice(price);
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
