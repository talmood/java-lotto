package strategy;

import vo.param.WinningMatchParam;

public class WinningPriceStrategyFactory {
	private static final WinningPriceStrategyFactory INSTANCE = new WinningPriceStrategyFactory();

	private WinningPriceStrategyFactory() {}

	public static WinningPriceStrategyFactory getInstance() {
		return INSTANCE;
	}

	public WinningPriceStrategy create(final WinningMatchParam winningMatchParam) {
		if (winningMatchParam.isThreeMatch()) return new ThreeMatchWinningStrategy();
		if (winningMatchParam.isFourMatch()) return new FourMatchWinningStrategy();
		if (winningMatchParam.isFiveMatch()) return new FiveMatchWinningStrategy();
		if (winningMatchParam.isFiveBonusMatch()) return new FiveBonusMatchWinningStrategy();
		if (winningMatchParam.isSixMatch()) return new SixMatchWinningStrategy();
		return null;
	}
}
