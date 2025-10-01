package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.*;

public class InputView {

    public int purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int input = userInput();
        // 아래 정리하기
        List<Integer> inputs = List.of(input);
        validateNotEmpty(inputs);
        validatePositiveInteger(inputs);

        return input;
    }

    public List<Integer> winningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        List<Integer> inputs = parseWinningNumbers(input);
        validateNotEmpty(inputs);
        validatePositiveInteger(inputs);
        validateDuplicates(inputs);

        return inputs;
    }

    public int bonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int input = userInput();

        List<Integer> inputs = List.of(input);
        validateNotEmpty(inputs);
        validatePositiveInteger(inputs);
        validateBonusNotInWinning(input, winningNumbers);

        return input;
    }

    private int userInput(){
        String input = Console.readLine();
        validateIsNumber(input);
        int inputs = Integer.parseInt(input);
        return inputs;
    }

    private List<Integer> parseWinningNumbers(String input) {
        List<Integer> inputs = Arrays.stream(input.split(",")).map(s -> {
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
            }
        }).toList();
        return inputs;
    }

    // 이거 정리하기
    private void validateNotEmpty(List<Integer> inputs) {
        if (inputs == null || inputs.isEmpty() || inputs.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("입력값에 null이 포함하거나 입력이 비어있습니다.");
        }
    }
    // 정리하기
    private void validateIsNumber(String input) {
        try {
            Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    private void validatePositiveInteger(List<Integer> inputs) {
        if (inputs.stream().anyMatch(i -> i <= 0)) {
            throw new IllegalArgumentException("양의 정수를 입력해야 합니다.");
        }
    }
    // 이거 정리하기
    private void validateDuplicates(List<Integer> inputs) {
        Set<Integer> unique = new HashSet<>(inputs);
        if (unique.size() != inputs.size()) throw new IllegalArgumentException("중복되는 숫자가 있습니다.");
    }
    // 이거 정리하기
    private void validateBonusNotInWinning(int input, List<Integer> winningNumbers) {
        if (winningNumbers.contains(input)) throw new IllegalArgumentException("보너스 번호와 당첨 번호는 달라야 합니다.");
    }
}
