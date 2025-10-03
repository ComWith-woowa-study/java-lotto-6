package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.service.LottoMatch;
import lotto.service.LottoStatistic;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoResultService {
    private final OutputView outputView;
    private final LottoMatch lottoMatch;
    private final LottoStatistic lottoStatistic;

    public LottoResultService(OutputView outputView, LottoMatch lottoMatch, LottoStatistic lottoStatistic) {
        this.outputView = outputView;
        this.lottoMatch = lottoMatch;
        this.lottoStatistic = lottoStatistic;
    }

    public void evaluate(List<Lotto> lottoList, WinningNumbers winningNumbers) {
        Map<Rank, Integer> matchResult = lottoMatch.LottoMatchs(lottoList, winningNumbers.getWinningNumbers(), winningNumbers.getBonus());
        double statistic = lottoStatistic.LottoStatistic(matchResult, lottoList);
        outputView.printWinningStatistics(matchResult, statistic);
    }
}
