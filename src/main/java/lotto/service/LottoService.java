package lotto.service;

import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Statistics;
import lotto.model.WinningNumbers;

public class LottoService {

    // 구매 금액만큼 로또 구매
    public Lottos buy(Money money) {
        return Lottos.buy(money.ticketCount());
    }

    // 로또 번호와 당첨 번호를 비교 평가
    public Statistics evaluate(Lottos lottos, WinningNumbers winningNumbers) {
        return lottos.evaluate(winningNumbers);
    }
}
