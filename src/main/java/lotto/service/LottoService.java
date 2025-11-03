package lotto.service;

import lotto.exception.ErrorMessage;
import lotto.model.*;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public List<Lotto> buyLottos(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT);
        }
        int count = amount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(LottoGenerator.createLotto());
        }
        return lottos;
    }

    public LottoResult calculateResult(List<Lotto> lottos, WinningLotto winningLotto) {
        LottoResult result = new LottoResult();

        for (Lotto lotto : lottos) {
            int matchCount = winningLotto.countMatch(lotto);
            boolean bonus = winningLotto.isBonusMatched(lotto);
            Rank rank = Rank.valueOf(matchCount, bonus);
            result.add(rank);
        }
        return result;
    }

}