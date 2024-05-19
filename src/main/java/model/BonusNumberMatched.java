package model;

public record BonusNumberMatched(
        boolean matched
) {

    public static BonusNumberMatched ofMatched() {
        return new BonusNumberMatched(true);
    }

    public static BonusNumberMatched ofNotMatched() {
        return new BonusNumberMatched(false);
    }

}
