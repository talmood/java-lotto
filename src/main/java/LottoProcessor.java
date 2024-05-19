public class LottoProcessor {

    private final InputView inputView;

    private final ResultView resultView;

    public LottoProcessor(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void processGame() {

        Integer price = acceptPriceForLottoGame();

        Integer gameCount = decideGameCount(price);
        resultView.printPurchasedGameCount(gameCount);

        createLottoByGameCount(gameCount);
        //14개를 구매했습니다.
        //[8, 21, 23, 41, 42, 43]

    }

    private void createLottoByGameCount(Integer gameCount) {
        Lotto lotto= new Lotto(gameCount);
        System.out.println("lotto = " + lotto.toString());

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
