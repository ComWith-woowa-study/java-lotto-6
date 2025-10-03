package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class MoneyTest {

    @DisplayName("로또 구매 금액이 1000원 단위가 아니면 예외 처리한다.")
    @Test
    void LottoPurchaseUnitTest() {
        assertThatThrownBy(() -> new Money(2300))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 1000원 단위면 정상 생성")
    @Test
    void validAmountDoesNotThrow() {
        assertThatCode(() -> new Money(3000))
                .doesNotThrowAnyException();
    }

    @DisplayName("금액에 따른 티켓 개수 반환")
    @Test
    void toTicketCountReturnsCorrectValue() {
        Money money = new Money(5000);
        assertThat(money.toTicketCount()).isEqualTo(5);
    }
}
