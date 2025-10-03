package lotto.domain;

public class Money {

    private final int amount;

    public Money(int amount) {
        if (amount % LottoRule.PRICE != 0) {
            throw new IllegalArgumentException("로또 구매 금액은 " + LottoRule.PRICE + "단위여야 합니다.");
        }
        this.amount = amount;
    }

    public int toTicketCount() {
        return amount / LottoRule.PRICE;
    }
}
