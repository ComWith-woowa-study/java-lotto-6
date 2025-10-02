package lotto;

import lotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {

    @DisplayName("보너스 번호가 1~45 범위 밖이면 예외")
    @Test
    void bonusOutOfRange() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1,2,3,4,5,6), 0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningNumbers(List.of(1,2,3,4,5,6), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 6개와 중복이면 예외")
    @Test
    void bonusDuplicateWithMain() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1,2,3,4,5,6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
