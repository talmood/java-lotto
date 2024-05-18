package vo.enums;

public enum WinningType {
	THREE_MATCH("3개 일치 (5000원)", 5000),
	FOUR_MATCH("4개 일치 (50000원)", 50000),
	FIVE_MATCH("5개 일치 (1500000원)", 1500000),
	FIVE_BONUS_MATCH("5개 일치, 보너스 볼 일치(30000000원)", 30000000),
	SIX_MATCH("6개 일치 (2000000000원)", 2000000000);

	private String title;
	private int winningPrice;

	WinningType(final String title, final int winningPrice) {
		this.title = title;
		this.winningPrice =winningPrice;
	}

	public String getTitle() {
		return this.title;
	}

	public int getWinningPrice() {
		return this.winningPrice;
	}
}
