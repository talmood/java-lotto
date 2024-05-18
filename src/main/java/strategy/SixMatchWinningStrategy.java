package strategy;

import vo.enums.WinningType;

public class SixMatchWinningStrategy implements WinningPriceStrategy {
	@Override
	public WinningType fetchWinningType() {
		return WinningType.SIX_MATCH;
	}
}
