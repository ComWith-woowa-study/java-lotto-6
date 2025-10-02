package lotto.model;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        if (lottos == null || lottos.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또를 구매하세요...");
        }
        this.lottos = lottos;
    }

    public static Lottos buy(int count) {
        List<Lotto> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return new Lottos(list);
    }

    public List<Lotto> all() {
        return lottos;
    }

    public Statistics evaluate(WinningNumbers wn) {
        Map<Rank, Integer> counts = new HashMap<>();
        for (Lotto lotto : lottos) {
            int matched = wn.matchedCount(lotto);
            boolean bonus = wn.bonusMatch(lotto);
            Rank rank = Rank.result(matched, bonus);
            counts.merge(rank, 1, Integer::sum);
        }

        return Statistics.of(counts);
    }
}
