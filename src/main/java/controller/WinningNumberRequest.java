package controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberRequest {
	private final List<Integer> winningNumbers;

	private static final String WINNING_NUMBER_SPLIT_REGEX = ",";

	private WinningNumberRequest(final List<Integer> winningNumbers) {
		this.winningNumbers = winningNumbers;
	}

	public static WinningNumberRequest from(final String winningNumberInput) {
		return new WinningNumberRequest(generateWinningNumber(winningNumberInput));
	}

	private static List<Integer> generateWinningNumber(final String winningNumberInput) {
		String[] splitInput = winningNumberInput
			.replaceAll(" ", "")
			.split(WINNING_NUMBER_SPLIT_REGEX);
		return Arrays.stream(splitInput)
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	public List<Integer> getWinningNumbers() {
		return List.copyOf(this.winningNumbers);
	}
}
