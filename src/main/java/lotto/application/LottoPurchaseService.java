package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.service.LottoMachine;
import lotto.util.Retry;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoPurchaseService {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public LottoPurchaseService(InputView inputView, OutputView outputView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }

    public List<Lotto> purchase() {
        int purchaseAmount = Retry.untilValid(inputView::purchaseAmount, outputView::printError);
        List<Lotto> lottoList = lottoMachine.createLottos(new Money(purchaseAmount));
        outputView.printLottoNumbers(lottoList);
        return lottoList;
    }
}

