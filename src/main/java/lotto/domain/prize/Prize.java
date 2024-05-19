package lotto.domain.prize;

public enum Prize {
    NONE(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int matchCount;
    private final boolean matchBonus;
    private final int money;

    Prize(final int matchCount, final boolean matchBonus, final int money) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.money = money;
    }

    public static Prize of(final int matchCount, final boolean matchBonus) {
        if (matchCount == SECOND.matchCount && matchBonus) {
            return SECOND;
        }
        for (final Prize prize : values()) {
            if (prize.matchCount == matchCount) {
                return prize;
            }
        }
        return NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getMoney() {
        return money;
    }
}
