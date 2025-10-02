package lotto.model;

public enum Rank {
    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    MISS(0, false, 0L);

    private final int match;
    private final boolean bonusExists;
    private final Long prize;

    Rank(int match, boolean bonusExists, Long prize) {
        this.match = match;
        this.bonusExists = bonusExists;
        this.prize = prize;
    }

    public long getPrize() {
        return prize;
    }

    public static Rank result(int matched, boolean bonusExists) {
        if (matched == 6) return FIRST;
        if (matched == 5 && bonusExists) return SECOND;
        if (matched == 5) return THIRD;
        if (matched == 4) return FOURTH;
        if (matched == 3) return FIFTH;
        return MISS;
    }
}
