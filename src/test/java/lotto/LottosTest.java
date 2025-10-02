package lotto;

import lotto.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("여러 장 채점 시 MISS 포함해 등수별 개수를 집계한다")
    @Test
    void evaluateCountsWithMiss() {
        WinningNumbers wn = new WinningNumbers(List.of(1,2,3,4,5,6), 7);

        Lotto first  = new Lotto(List.of(1,2,3,4,5,6));
        Lotto second = new Lotto(List.of(1,2,3,4,5,7));
        Lotto third  = new Lotto(List.of(1,2,3,4,5,45));
        Lotto fourth = new Lotto(List.of(1,2,3,4,44,45));
        Lotto fifth  = new Lotto(List.of(1,2,3,43,44,45));
        Lotto miss   = new Lotto(List.of(10,11,3,41,42,43));

        Lottos lottos = new Lottos(List.of(first, second, third, fourth, fifth, miss));
        Statistics stats = lottos.evaluate(wn);

        assertThat(stats.count(Rank.FIRST)).isEqualTo(1);
        assertThat(stats.count(Rank.SECOND)).isEqualTo(1);
        assertThat(stats.count(Rank.THIRD)).isEqualTo(1);
        assertThat(stats.count(Rank.FOURTH)).isEqualTo(1);
        assertThat(stats.count(Rank.FIFTH)).isEqualTo(1);
        assertThat(stats.count(Rank.MISS)).isEqualTo(1);
    }
}
