package domain;

import java.util.Objects;

public class WinningNumber {

    private final int winningNumber;

    private WinningNumber(int winningNumber) {
        this.winningNumber = winningNumber;
    }

    public static WinningNumber create(int winningNumber) {
        return new WinningNumber(winningNumber);
    }

    public boolean isSameNumber(int number) {
        return this.winningNumber == number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumber that = (WinningNumber) o;
        return winningNumber == that.winningNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumber);
    }
}
