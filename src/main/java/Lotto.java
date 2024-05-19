import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List <LottoGame> LottoGames;

    public List<LottoGame> getLottoGames() {
        return new ArrayList<>(LottoGames);
    }

    public Lotto(Integer gameCount) {
        this.LottoGames = new ArrayList<>();
        for (int i = 0; i < gameCount; i++) {
            LottoGame lottoGame = createLottoGame();
            this.LottoGames.add(lottoGame);
        }
    }

    private LottoGame createLottoGame() {
        int minimumLottoValue = 1;
        int maximumLottoValue = 46;
        int lottoNumberCount = 6;
        List<Integer> potentialLottoNumbers = new ArrayList<>();
        for (int i = minimumLottoValue; i <= maximumLottoValue; i++) {
            potentialLottoNumbers.add(i);
        }
        Collections.shuffle(potentialLottoNumbers);
        List<Integer> gameNumbers = new ArrayList<>(potentialLottoNumbers.subList(0, lottoNumberCount));
        Collections.sort(gameNumbers);

        return new LottoGame(gameNumbers);
    }
    public static class LottoGame {
        private final List<Integer> gameNumbers;

        public LottoGame(List<Integer> gameNumbers) {
            this.gameNumbers = new ArrayList<>(gameNumbers);
        }

        @Override
        public String toString() {
            return  gameNumbers.toString();
        }
    }

}
