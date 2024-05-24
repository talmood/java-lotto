package view;

import model.LottoGame;
import model.LottoWinningGame;
import model.lottonumber.LottoNumber;
import model.lottonumber.LottoNumberPool;

import java.util.Arrays;
import java.util.List;

public class InputLottoWinningGame {

    private final List<Integer> winningNumbers;

    private InputLottoWinningGame(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static InputLottoWinningGame fromNumberLiterals(String winningGameLiteral) {
        final List<Integer> numbers = Arrays.stream(winningGameLiteral.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        return new InputLottoWinningGame(numbers);
    }

    public LottoWinningGame toLottoWinningGame() {
        final List<LottoNumber> numbers = this.winningNumbers.stream()
                .map(number -> LottoNumberPool.getInstance().getNumberBy(number))
                .toList();

        return new LottoWinningGame(new LottoGame(numbers));
    }

}
