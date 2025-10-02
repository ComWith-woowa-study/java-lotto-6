package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public String readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public List<Integer> readWinningNumbers() {
        List<Integer> list = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().trim().split(",");
        for (String s : input) {
            list.add(Integer.parseInt(s));
        }

        return list;
    }

    public int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
