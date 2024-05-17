package view.input.dto;

import domain.WinningNumber;
import domain.WinningNumbers;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbersInput {

    private final List<Integer> winningNumbers;

    public WinningNumbersInput(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public WinningNumbers toWinningNumbers() {
        return WinningNumbers.create(
                this.winningNumbers.stream()
                        .map(WinningNumber::create)
                        .collect(Collectors.toList())
        );
    }
}
