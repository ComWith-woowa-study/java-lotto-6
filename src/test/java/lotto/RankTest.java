package lotto;

import lotto.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("매칭된 숫자에 따른 등수가 잘못되면 예외가 발생한다.")
    @Test
    void rankMapping() {
        assertThat(Rank.result(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.result(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.result(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.result(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.result(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.result(4, true)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.result(0, false)).isEqualTo(Rank.MISS);
        assertThat(Rank.result(1, true)).isEqualTo(Rank.MISS);
        assertThat(Rank.result(2, false)).isEqualTo(Rank.MISS);
    }
}
