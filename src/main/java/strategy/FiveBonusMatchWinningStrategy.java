package strategy;

import vo.enums.WinningType;

public class FiveBonusMatchWinningStrategy implements WinningPriceStrategy {
	@Override
	public WinningType fetchWinningType() {
		return WinningType.FIVE_BONUS_MATCH;
	}
}
