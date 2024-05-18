package vo.param;

public class WinningMatchParam {
	private final int winningMatchCount;
	private final boolean isMatchBonus;

	private WinningMatchParam(final int winningMatchCount, final boolean isMatchBonus) {
		this.winningMatchCount = winningMatchCount;
		this.isMatchBonus = isMatchBonus;
	}

	public static WinningMatchParam from(final int winningMatchCount, final boolean isMatchBonus) {
		return new WinningMatchParam(winningMatchCount, isMatchBonus);
	}

	public boolean isThreeMatch() {
		return this.winningMatchCount == 3;
	}

	public boolean isFourMatch() {
		return this.winningMatchCount == 4;
	}

	public boolean isFiveMatch() {
		return this.winningMatchCount == 5 && !isMatchBonus;
	}

	public boolean isFiveBonusMatch() {
		return this.winningMatchCount == 5 && isMatchBonus;
	}

	public boolean isSixMatch() {
		return this.winningMatchCount == 6;
	}
}
