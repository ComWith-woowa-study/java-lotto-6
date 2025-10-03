package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator implements LottoNumberGenerator {

    @Override
    public List<Integer> generate(int min, int max, int count) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(min, max, count);
        return numbers;
    }
}
