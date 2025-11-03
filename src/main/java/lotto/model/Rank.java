package lotto.model;

public enum Rank {
    FIRST(6, false, 2_000_000_000), // 1등: 6개 번호 일치 / 2,000,000,000원
    SECOND(5, true, 30_000_000), // 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    THIRD(5, false, 1_500_000), // 3등: 5개 번호 일치 / 1,500,000원
    FOURTH(4, false, 50_000), // 4등: 4개 번호 일치 / 50,000원
    FIFTH(3, false, 5_000), // 5등: 3개 번호 일치 / 5,000원
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean bonus;
    private final int reward;

    Rank(int matchCount, boolean bonus, int reward) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.reward = reward;
    }

    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return FIRST; // 6개 번호 일치
        if (matchCount == 5 && bonusMatch) return SECOND; // 5개 번호 + 보너스 번호 일치
        if (matchCount == 5) return THIRD; // 5개 번호 일치
        if (matchCount == 4) return FOURTH; // 4개 번호 일치
        if (matchCount == 3) return FIFTH; // 3개 번호 일치
        return NONE;
    }

    public int getReward() {
        return reward;
    }
}

