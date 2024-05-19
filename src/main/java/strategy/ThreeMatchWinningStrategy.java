package strategy;

import vo.enums.WinningType;

public class ThreeMatchWinningStrategy implements WinningPriceStrategy {
	@Override
	public WinningType fetchWinningType() {
		return WinningType.THREE_MATCH;
	}
}
