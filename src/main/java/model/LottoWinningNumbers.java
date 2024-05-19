package model;

public record LottoWinningNumbers(
        LottoWinningGame winningGame,
        LottoBonusNumber bonusNumber
) {

    public LottoWinningNumbers {
        if (winningGame.containsNumber(bonusNumber.number())) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    public LottoWinningResult calculateWinningResult(LottoTicket lottoTicket) {
        return LottoWinningResult.of(this, lottoTicket);
    }

    public LottoGame fetchWiningGame() {
        return this.winningGame.game();
    }

    public LottoNumber fetchBonusNumber() {
        return this.bonusNumber.number();
    }

}
