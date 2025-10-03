package lotto.generator;

import java.util.List;

public interface LottoNumberGenerator {
    public List<Integer> generate(int min, int max, int count);
}