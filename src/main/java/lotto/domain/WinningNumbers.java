package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winWithBonusNumbers;
    private final int bonus;

    public WinningNumbers(List<Integer> numbers, int bonus){
        this.winWithBonusNumbers = numbers;
        this.bonus = bonus;
    }
    public List<Integer> getWinWithBonusNumbers() {
        return winWithBonusNumbers;
    }
    public int getBonus() {
        return bonus;
    }
}
