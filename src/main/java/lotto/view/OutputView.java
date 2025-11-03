package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Rank;

import java.util.List;

public class OutputView {
    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResult(LottoResult result, int amount) {
        List<Rank> ranksToDisplay = List.of(
                Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST
        );
        System.out.println("\n당첨 통계\n---");
        for (Rank rank : ranksToDisplay) {
            if (rank == Rank.NONE) continue;

            String bonusText = "";
            if (rank.hasBonusMatch()) {
                bonusText = ", 보너스 볼 일치";
            }

            System.out.printf("%d개 일치%s (%,d원) - %d개%n",
                    rank.getMatchCount(),
                    bonusText,
                    rank.getReward(),
                    result.getResult().getOrDefault(rank, 0)
            );
        }
        double rate = result.calculateProfit(amount);
        System.out.printf("총 수익률은 %,.1f%%입니다.%n", rate);
    }
}

