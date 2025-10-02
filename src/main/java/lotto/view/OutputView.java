package lotto.view;

import lotto.model.Lotto;
import lotto.dto.ResultResponse;
import lotto.model.Lottos;
import lotto.model.Rank;

public class OutputView {

    public void printPurchased(Lottos lottos) {
        System.out.println(lottos.all().size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.all()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResult(ResultResponse result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result.getStats().count(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.getStats().count(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getStats().count(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getStats().count(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getStats().count(Rank.FIRST) + "개");
        System.out.println("총 수익률은 " + result.getStats().yieldRate(result.getPaid()) + "입니다.");
    }

    public void error(String message) {
        System.out.println(message);
    }
}
