import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    public void setLottoGames(List<LottoGame> lottoGames) {
        LottoGames = lottoGames;
    }

    List<LottoGame> LottoGames;

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

}
