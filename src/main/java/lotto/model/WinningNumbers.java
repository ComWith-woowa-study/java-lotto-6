package lotto.model;

import java.util.List;

public class WinningNumbers {

    private static final int BONUS_MIN = 1;
    private static final int BONUS_MAX = 45;

    private final Lotto numbers;
    private final int bonus;

    public WinningNumbers(List<Integer> numbers, int bonus) {
        this.numbers = new Lotto(numbers);
        validateBonus(bonus);
        this.bonus = bonus;
    }

    private void validateBonus(int bonus) {
        if (bonus < BONUS_MIN || bonus > BONUS_MAX) {
            throw new IllegalArgumentException(String.format("[ERROR] 보너스 번호는 %d부터 %d 사이의 숫자여야 합니다.", BONUS_MIN, BONUS_MAX));
        }

        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다!");
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public boolean bonusMatch(Lotto lotto) {
        return lotto.contains(bonus);
    }

    public int matchedCount(Lotto lotto) {
        return lotto.matchCount(this);
    }

}
