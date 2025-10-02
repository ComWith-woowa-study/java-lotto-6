package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.Map;

public class Statistics {

    private final Map<Rank, Integer> counts;

    public Statistics(Map<Rank, Integer> counts) {
        this.counts = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            this.counts.put(rank, counts.getOrDefault(rank, 0));
        }
    }

    public static Statistics of(Map<Rank, Integer> counts) {
        return new Statistics(counts);
    }

    public Long totalPrize() {
        return counts.entrySet().stream()
                .mapToLong(e -> e.getKey().getPrize() * e.getValue()).sum();
    }

    public String yieldRate(int pay) {
        BigDecimal rate = BigDecimal.valueOf(totalPrize())
                .divide(BigDecimal.valueOf(pay), 4, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100));

        return rate.setScale(1, RoundingMode.HALF_UP) + "%";
    }

    public int count(Rank rank) {
        return counts.getOrDefault(rank, 0);
    }
}
