import java.util.ArrayList;
import java.util.List;

public class WinningLottoNumber {
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public WinningLottoNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = new ArrayList<>(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
