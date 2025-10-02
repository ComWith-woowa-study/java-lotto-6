package lotto.service;

import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Statistics;
import lotto.model.WinningNumbers;

public class LottoService {

    public Lottos buy(Money money) {
        return Lottos.buy(money.ticketCount());
    }

    public Statistics evaluate(Lottos lottos, WinningNumbers winningNumbers) {
        return lottos.evaluate(winningNumbers);
    }
}
