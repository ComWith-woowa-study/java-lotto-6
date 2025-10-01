package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.service.LottoStatistic;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printLottoNumbers(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningStatistics(Map<Rank, Integer> determineRank, double LottoStatistic) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + determineRank.get(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + determineRank.get(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + determineRank.get(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + determineRank.get(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + determineRank.get(Rank.FIRST) + "개");
        // 여기 정리하기
        System.out.println("총 수익률은 " + String.format("%,.1f%%", LottoStatistic) + "입니다.");
    }

    public void printError(String msg) {
        System.out.println("[ERROR] " + msg);
    }
}
