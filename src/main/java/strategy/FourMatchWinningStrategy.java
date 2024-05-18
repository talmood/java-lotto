package strategy;

import vo.enums.WinningType;

public class FourMatchWinningStrategy implements WinningPriceStrategy {
	@Override
	public WinningType fetchWinningType() {
		return WinningType.FOUR_MATCH;
	}
}
