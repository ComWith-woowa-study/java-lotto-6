package lotto;

import lotto.model.Rank;
import lotto.model.Statistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {

    @DisplayName("총 상금과 수익률을 계산한다(반올림 자리 확인)")
    @Test
    void totalPrizeAndYieldRate() {
        Map<Rank, Integer> m = new EnumMap<>(Rank.class);
        m.put(Rank.FIFTH, 1);  // 5,000
        m.put(Rank.FOURTH, 2); // 100,000
        Statistics s = Statistics.of(m);

        assertThat(s.totalPrize()).isEqualTo(105_000L);
        assertThat(s.yieldRate(8_000)) // 105000 / 8000 * 100 = 1312.5%
                .isEqualTo("1312.5%");
    }
}
