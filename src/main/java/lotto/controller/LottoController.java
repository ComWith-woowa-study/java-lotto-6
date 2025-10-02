package lotto.controller;

import lotto.dto.ResultResponse;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Statistics;
import lotto.model.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView input;
    private final OutputView output;
    private final LottoService service;

    public LottoController(InputView input, OutputView output, LottoService service) {
        this.input = input;
        this.output = output;
        this.service = service;
    }

    public void run() {
        Money money = askMoney();
        Lottos lottos = service.buy(money);
        output.printPurchased(lottos);

        WinningNumbers winning = askWinning();
        Statistics stats = service.evaluate(lottos, winning);
        output.printResult(new ResultResponse(stats, money.getAmount()));
    }

    private Money askMoney() {
        while (true) {
            try {
                return new Money(input.readMoney());
            } catch (IllegalArgumentException e) {
                output.error(e.getMessage());
            }
        }
    }

    private WinningNumbers askWinning() {
        while (true) {
            try {
                List<Integer> numbers = input.readWinningNumbers();
                int bonus = input.readBonusNumber();
                return new WinningNumbers(numbers, bonus);
            } catch (IllegalArgumentException e) {
                output.error(e.getMessage());
            }
        }
    }
}
