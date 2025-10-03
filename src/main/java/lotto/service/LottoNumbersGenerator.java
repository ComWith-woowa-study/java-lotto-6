package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumbersGenerator implements NumbersGenerator {

    @Override
    public List<Integer> pick() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
