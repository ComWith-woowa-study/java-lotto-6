package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchResult {
    private final List<Integer> matchNumbers;
    private final int count;
    private final boolean isBonusNumber;

    public MatchResult(List<Integer> numbers, boolean BonusNumber) {
        this.matchNumbers = new ArrayList<>(numbers);
        this.count = numbers.size();
        this.isBonusNumber = BonusNumber;
    }

    public List<Integer> getmatchNumbers() {
        return matchNumbers;
    }

    public int getCount() {
        return count;
    }

    public boolean isBonusNumber() {
        return isBonusNumber;
    }
}
