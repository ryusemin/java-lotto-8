package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public List<Lotto> buyLottos(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
        int count = amount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(LottoGenerator.createLotto());
        }
        return lottos;
    }

}