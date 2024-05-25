package model;

import model.lottonumber.LottoNumber;

public record LottoWinningGame(
        LottoGame game
) {

    public boolean containsNumber(LottoNumber number) {
        return this.game.containsNumber(number);
    }

}
