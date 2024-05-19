package strategy;

import vo.enums.WinningType;

public class FiveMatchWinningStrategy implements WinningPriceStrategy {
	@Override
	public WinningType fetchWinningType() {
		return WinningType.FIVE_MATCH;
	}
}
