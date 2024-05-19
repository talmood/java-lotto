import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;


class LottoProcessorTest {

    private ResultView resultView;
    private InputView inputView;
    private LottoProcessor lottoProcessor;

    @BeforeEach
    void setUp() {
        resultView = Mockito.mock(ResultView.class);
        inputView = Mockito.mock(InputView.class);
        lottoProcessor = new LottoProcessor(inputView, resultView);
    }


    @Test
    void purchaseGamesByPrice() {

        Integer price = 14000;
        Integer gameCount = lottoProcessor.purchaseGamesByPrice(price);
        assertEquals(14, gameCount);

        verify(resultView).printPurchasedGameCount(gameCount);
    }

    @Test
    void createLottoByGameCount() {
        Integer gameCount = 14;

        Lotto lotto = lottoProcessor.createLottoByGameCount(gameCount);
        assertEquals(gameCount, lotto.getLottoGames().size());

        verify(resultView).printLottoGameNumbers(lotto);
    }

    @Test
    void selectWinners() {
        Integer gameCount = 5;

        Lotto lotto = new Lotto(gameCount);

        List<LottoGame> lottoGames = List.of(
                new LottoGame(List.of(1, 2, 3, 4, 5, 6)),
                new LottoGame(List.of(1, 2, 3, 4, 5, 7)),
                new LottoGame(List.of(1, 2, 3, 4, 5, 16)),
                new LottoGame(List.of(1, 2, 3, 4, 15, 16)),
                new LottoGame(List.of(1, 2, 3, 14, 15, 16))
        );
        lotto.setLottoGames(lottoGames);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;

        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(winningNumbers, bonusNumber);
        Winners winners = lottoProcessor.selectWinners(lotto, winningLottoNumber);

        assertEquals(winners.getFirstWinner(), 1);
        assertEquals(winners.getSecondWinner(), 1);
        assertEquals(winners.getThirdWinner(), 1);
        assertEquals(winners.getFourthWinner(), 1);
        assertEquals(winners.getFifthWinner(), 1);


    }
}