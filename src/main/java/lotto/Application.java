package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoNumbersGenerator;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        LottoController controller = new LottoController(
                new InputView(), new OutputView(), new LottoService(new LottoNumbersGenerator())
        );

        controller.run();
    }
}
