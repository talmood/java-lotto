package lotto;

public class WinningLotto {

	private final Lotto winningLotto;
	private final LottoNumber bonusLottoNumber;

	private WinningLotto(final Lotto winningLotto, final LottoNumber bonusLottoNumber) {
		this.winningLotto = winningLotto;
		this.bonusLottoNumber = bonusLottoNumber;
	}

	public static WinningLotto of(final Lotto winningLotto, final LottoNumber bonusLottoNumber) {
		validateDuplication(winningLotto, bonusLottoNumber);
		return new WinningLotto(winningLotto, bonusLottoNumber);
	}

	private static void validateDuplication(final Lotto winningLotto, final LottoNumber bonusLottoNumber) {
		if (winningLotto.isContains(bonusLottoNumber)) {
			throw new IllegalArgumentException("당첨 번호와 보너스 번호는 겹칠 수 없습니다.");
		}
	}
}
