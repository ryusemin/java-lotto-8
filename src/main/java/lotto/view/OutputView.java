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
        System.out.println("\n당첨 통계\n---");
        printRankStatistics(result);
        printProfitRate(result, amount);
    }

    private void printRankStatistics(LottoResult result) {
        List<Rank> ranksToDisplay = List.of(
                Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST
        );

        for (Rank rank : ranksToDisplay) {
            String formatted = formatRankResult(rank, result.getResult().getOrDefault(rank, 0));
            System.out.println(formatted);
        }
    }


    private String formatRankResult(Rank rank, int count) {
        String bonusText = "";
        if (rank.hasBonusMatch()) {
            bonusText = ", 보너스 볼 일치";
        }

        return String.format("%d개 일치%s (%,d원) - %d개",
                rank.getMatchCount(),
                bonusText,
                rank.getReward(),
                count
        );
    }

    private void printProfitRate(LottoResult result, int amount) {
        double rate = result.calculateProfit(amount);
        System.out.printf("총 수익률은 %,.1f%%입니다.%n", rate);
    }
}

