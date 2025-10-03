package lotto;

import lotto.application.LottoPurchaseService;
import lotto.application.LottoResultService;
import lotto.application.WinningAndBonusInputService;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import lotto.generator.LottoNumberGenerator;
import lotto.generator.RandomNumberGenerator;
import lotto.service.LottoMachine;
import lotto.service.LottoMatch;
import lotto.service.LottoStatistic;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoNumberGenerator lottoNumberGenerator = new RandomNumberGenerator();
        LottoMachine lottoMachine = new LottoMachine(lottoNumberGenerator);
        LottoMatch lottoMatch = new LottoMatch();
        LottoStatistic lottoStatistic = new LottoStatistic();

        LottoPurchaseService purchaseService = new LottoPurchaseService(inputView, outputView, lottoMachine);
        WinningAndBonusInputService winningAndBonusInputService = new WinningAndBonusInputService(inputView, outputView);
        LottoResultService resultService = new LottoResultService(outputView, lottoMatch, lottoStatistic);

        List<Lotto> lottoList = purchaseService.purchase();
        WinningNumbers winningNumbers = winningAndBonusInputService.input();
        resultService.evaluate(lottoList, winningNumbers);
    }
}
