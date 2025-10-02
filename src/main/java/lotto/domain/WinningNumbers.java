package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final Lotto winningNumbers;
    private final int bonus;

    public WinningNumbers(Lotto numbers, int bonus){
        this.winningNumbers = numbers;
        this.bonus = bonus;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonus() {
        return bonus;
    }

}
