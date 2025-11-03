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
        int amount = inputView.inputPurchaseAmount();
        List<Lotto> purchased = lottoService.buyLottos(amount);
        outputView.printPurchasedLottos(purchased);

        WinningLotto winningLotto = inputView.inputWinningLotto();
        LottoResult result = lottoService.calculateResult(purchased, winningLotto);

        outputView.printResult(result, amount);

    }
}
