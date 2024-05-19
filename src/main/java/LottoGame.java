import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final List<Integer> gameNumbers;

    public LottoGame(List<Integer> gameNumbers) {
        this.gameNumbers = new ArrayList<>(gameNumbers);
    }

    @Override
    public String toString() {
        return  gameNumbers.toString();
    }

    public List<Integer> getGameNumbers() {
        return gameNumbers;
    }
}
