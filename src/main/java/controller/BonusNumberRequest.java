package controller;

public class BonusNumberRequest {
	private final int bonusNumber;

	private BonusNumberRequest(final int bonusNumber) {
		this.bonusNumber = bonusNumber;
	}

	public static BonusNumberRequest from(final String bonusNumberInput) {
		return new BonusNumberRequest(generateBonusNumber(bonusNumberInput));
	}

	private static int generateBonusNumber(final String bonusNumberInput) {
		return Integer.parseInt(bonusNumberInput);
	}

	public int getBonusNumber() {
		return this.bonusNumber;
	}
}
