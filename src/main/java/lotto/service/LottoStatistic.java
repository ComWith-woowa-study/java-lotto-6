package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRule;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class LottoStatistic {

    public double LottoStatistic(Map<Rank, Integer> LottoMatchResult, List<Lotto> lottos) {
        long totalPayout = 0L;
        totalPayout = 5000L * LottoMatchResult.getOrDefault(Rank.FIFTH, 0);
        totalPayout += 50000L * LottoMatchResult.getOrDefault(Rank.FOURTH, 0);
        totalPayout += 1500000L * LottoMatchResult.getOrDefault(Rank.THIRD, 0);
        totalPayout += 30000000L * LottoMatchResult.getOrDefault(Rank.SECOND, 0);
        totalPayout += 2000000000L * LottoMatchResult.getOrDefault(Rank.FIRST, 0);

        long cost = (long) lottos.size() * LottoRule.PRICE;
        if (cost == 0) return 0.0;

        double percent = (double) totalPayout / cost * 100.0;

        return Math.round(percent * 10.0) / 10.0;
    }
}
