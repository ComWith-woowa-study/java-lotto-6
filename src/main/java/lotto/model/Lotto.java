package lotto.model;

import java.util.*;
import java.util.stream.Collectors;

// 로또 클래스
public class Lotto {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = Collections.unmodifiableList(numbers.stream()
                .sorted()
                .collect(Collectors.toList()));
    }

    private void validateNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            if (number < MIN || number > MAX) {
                throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자를 입력해야 합니다.", MIN, MAX));
            }

            if (!set.add(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
            }
        }

        if (numbers == null || numbers.size() != SIZE) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %d개를 골라야 합니다.", SIZE));
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int matchCount(WinningNumbers wn) {
        return (int) numbers.stream().filter(wn::contains).count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
