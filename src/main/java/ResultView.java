import java.util.List;

public class ResultView {
    public void printPurchasedGameCount(Integer gameCount) {
        System.out.println(gameCount + "개를 구매했습니다.");
    }

    public void printLottoGameNumbers(Lotto lotto) {
        List<Lotto.LottoGame> lottoGames = lotto.getLottoGames();
        for (int i = 0; i < lottoGames .size(); i++) {
            System.out.println(lottoGames.get(i));
        }
    }
}
