import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoProcessor {

    private final InputView inputView;

    private final ResultView resultView;

    public LottoProcessor(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void processGame() {

        Integer price = acceptPriceForLottoGame();
        Integer gameCount = purchaseGamesByPrice(price);
        Lotto lotto = createLottoByGameCount(gameCount);
        WinningLottoNumber winningLottoNumber = acceptWinningNumbers();
        Winners winners = selectWinners(lotto, winningLottoNumber);
        showWinnerStatistics(winners, price);
    }

    private void showWinnerStatistics(Winners winners, Integer price) {
        resultView.printWinnerStatisticsMessage();
        ProfitCalculator profitCalculator = new ProfitCalculator(winners, price);
        resultView.printWinnerStatistics(winners, profitCalculator);
    }


    public Lotto createLottoByGameCount(Integer gameCount) {
        Lotto lotto = new Lotto(gameCount);
        resultView.printLottoGameNumbers(lotto);
        return lotto;
    }

    public Integer purchaseGamesByPrice(Integer price) {
        GameCountDecider gameCountDecider = new GameCountDecider();
        Integer gameCount = gameCountDecider.calculateGameForPrice(price);
        resultView.printPurchasedGameCount(gameCount);

        return gameCount;
    }

    private int acceptPriceForLottoGame() {
        inputView.guideToPutPurchasePrice();
        Integer price;

        do {
            String stringInput = inputView.acceptInput();
            price = inputView.validatePurchasePrice(stringInput);
        } while (price == null);

        return price;
    }

    private WinningLottoNumber acceptWinningNumbers() {
        inputView.guideToPutWinningNumbers();
        String stringWinningNumbers = inputView.acceptInput();
        List<Integer> winningNumbers = Arrays.stream(stringWinningNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt).collect(Collectors.toList());

        inputView.guideToPutBonusNumber();
        int bonusNumber = Integer.parseInt(inputView.acceptInput());

        return new WinningLottoNumber(winningNumbers, bonusNumber);
    }

    public Winners selectWinners(Lotto lotto, WinningLottoNumber winningLottoNumber) {
        WinnerSelector winnerSelector = new WinnerSelector(lotto, winningLottoNumber);
        return winnerSelector.getWinners();
    }
}
