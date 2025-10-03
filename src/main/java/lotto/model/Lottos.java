package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.service.NumbersGenerator;

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

    // 구매한 만큼 로또 생성
    public static Lottos buy(int count, NumbersGenerator generator) {
        List<Lotto> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(new Lotto(generator.pick()));
        }

        return new Lottos(list);
    }

    public List<Lotto> all() {
        return lottos;
    }

    // 당첨 번호로 평가 후 결과 반환(등수 및 상금)
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
