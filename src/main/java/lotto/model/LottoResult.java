package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> result = new EnumMap<>(Rank.class);

    public void add(Rank rank) {
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    // 수익률 계산
    public double calculateProfit(int totalAmount) {
        int sum = result.entrySet().stream()
                .mapToInt(e -> e.getKey().getReward() * e.getValue())
                .sum();
        return (double) sum / totalAmount * 100;
    }
}

