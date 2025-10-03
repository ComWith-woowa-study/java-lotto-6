package lotto.service;

import lotto.domain.MatchResult;
import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.*;

public class LottoMatch {

    public Map<Rank, Integer> LottoMatchs(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        List<MatchResult> matchResults = match(lottos, winningNumbers, bonusNumber);
        return determineRank(matchResults);
    }

    private List<MatchResult> match(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        List<MatchResult> results = new ArrayList<>();
        List<Integer> winNums = winningNumbers.getNumbers();

        for (Lotto lotto : lottos) {
            List<Integer> match = new ArrayList<>(lotto.getNumbers());
            match.retainAll(winNums);
            boolean bonus = lotto.getNumbers().contains(bonusNumber);

            results.add(new MatchResult(match, bonus));
        }
        return results;
    }

    private Map<Rank, Integer> determineRank(List<MatchResult> matchResults) {
        Map<Rank, Integer> stats = makeMap();

        for (MatchResult matchResult : matchResults) {
            Rank rank = Rank.of(matchResult.getCount(), matchResult.isBonusNumber());
            stats.put(rank, stats.get(rank) + 1);
        }
        return stats;
    }

    private Map<Rank, Integer> makeMap() {
        Map<Rank, Integer> stats = new HashMap<>();
        for (Rank rank : Rank.values()) {
            stats.put(rank, 0);
        }
        return stats;
    }

}
