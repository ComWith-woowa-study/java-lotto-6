package lotto.model;

public class Money {

    private static final int LOTTO_PRICE = 1000;  // 로또 1장 가격
    private final int amount;  // 지불 금액

    public Money(String amount) {
        int value = parse(amount);
        validate(value);
        this.amount = value;
    }

    private int parse(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다!");
        }
    }

    private void validate(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 로또는 최소 1장은 구매해야 합니다.");
        }

        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위입니다!");
        }
    }

    public int getAmount() {
        return amount;
    }

    public int ticketCount() {
        return amount / LOTTO_PRICE;
    }
}
