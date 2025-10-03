package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false),
    SECOND(5, true),
    THIRD(5, false),
    FOURTH(4, false),
    FIFTH(3, false),
    NONE(0, false);

    private final int count;
    private final boolean isBonus;

    Rank(int count, boolean isBonus) {
        this.count = count;
        this.isBonus = isBonus;
    }

    public static Rank of(int count, boolean bonus) {
        return Arrays.stream(values())
                .filter(r -> r.count == count)
                .filter(r -> !r.isBonus || bonus)
                .findFirst()
                .orElse(NONE);
    }
}
