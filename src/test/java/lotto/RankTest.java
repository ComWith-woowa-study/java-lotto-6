package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RankTest {

    @DisplayName("6개 일치 - 1등")
    @Test
    void rankFirst() {
        assertThat(Rank.of(6, false)).isEqualTo(Rank.FIRST);
    }

    @DisplayName("5개 일치 + 보너스 일치 - 2등")
    @Test
    void rankSecond() {
        assertThat(Rank.of(5, true)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("5개 일치 - 3등")
    @Test
    void rankThird() {
        assertThat(Rank.of(5, false)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("4개 일치 - 4등")
    @Test
    void rankFourth() {
        assertThat(Rank.of(4, false)).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("3개 일치 - 5등")
    @Test
    void rankFifth() {
        assertThat(Rank.of(3, false)).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("2개 이하 일치 - 꽝")
    @Test
    void rankNone() {
        assertThat(Rank.of(2, false)).isEqualTo(Rank.NONE);
    }

}
