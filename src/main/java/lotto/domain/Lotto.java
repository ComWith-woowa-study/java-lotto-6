package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicates(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoRule.SIZE) {
            throw new IllegalArgumentException("로또 번호는 " + LottoRule.SIZE + "자리여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for(Integer number : numbers) {
            if (LottoRule.MIN > number || number > LottoRule.MAX) {
                throw new IllegalArgumentException(LottoRule.MIN + "~" + LottoRule.MAX + "이내로 입력해야 합니다.");
            }
        }
    }

    private void validateDuplicates(List<Integer> inputs) {
        Set<Integer> unique = new HashSet<>(inputs);
        if (unique.size() != inputs.size()) throw new IllegalArgumentException("중복되는 숫자가 있습니다.");
    }

}
