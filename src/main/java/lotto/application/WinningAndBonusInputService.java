package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import lotto.util.Retry;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.List;

public class WinningAndBonusInputService {
    private final InputView inputView;
    private final OutputView outputView;

    public WinningAndBonusInputService(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public WinningNumbers input() {
        Lotto numbers = Retry.untilValid(inputView::winningNumbers, outputView::printError);
        int bonus = Retry.untilValid(inputView::bonusNumber, outputView::printError);
        return new WinningNumbers(numbers, bonus);
    }
}
