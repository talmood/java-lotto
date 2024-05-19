package model;

public record WinningNumberMatchCount(
        long count
) {

    public boolean countEquals(long count) {
        return this.count == count;
    }

}
