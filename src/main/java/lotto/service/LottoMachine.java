package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRule;
import lotto.domain.Money;
import lotto.generator.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoMachine(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> createLottos(Money money) {
        int count = money.toTicketCount();
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = lottoNumberGenerator.generate(LottoRule.MIN, LottoRule.MAX, LottoRule.SIZE);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }
}
