package model;

public class LottoWinningGame {

    private final LottoGame winningGame;

    public LottoWinningGame(LottoGame winningGame) {
        this.winningGame = winningGame;
    }

    public boolean containsNumber(LottoNumber number) {
        return this.winningGame.containsNumber(number);
    }

}
