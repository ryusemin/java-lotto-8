package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService){
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        List<Lotto> purchased = getValidLottos();
        WinningLotto winningLotto = getValidWinningLotto();

        LottoResult result = lottoService.calculateResult(purchased, winningLotto);

        outputView.printResult(result, purchased.size());
    }

    private List<Lotto> getValidLottos() {
        while (true) {
            try {
                int amount = inputView.inputPurchaseAmount();
                List<Lotto> purchased = lottoService.buyLottos(amount);
                outputView.printPurchasedLottos(purchased);
                return purchased;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningLotto getValidWinningLotto() {
        while (true) {
            try {
                return inputView.inputWinningLotto();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
