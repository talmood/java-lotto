package model;

public record LottoWinningGame(
        LottoGame game
) {

    public boolean containsNumber(LottoNumber number) {
        return this.game.containsNumber(number);
    }

}
