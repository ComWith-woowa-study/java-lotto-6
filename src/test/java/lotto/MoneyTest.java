package lotto;

import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @DisplayName("구매 금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void notEnoughMoney() {
        assertThatThrownBy(() -> new Money("100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액 단위가 1000원이 아니라면 예외가 발생한다.")
    @Test
    void notMultipleOfOneThousand() {
        assertThatThrownBy(() -> new Money("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
