package lotto.model;

import lotto.exception.ErrorMessage;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS);
        }
    }

    // 당첨 번호 일치 개수 반환
    public int countMatch(Lotto lotto) {
        long match = lotto.getNumbers().stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
        return (int) match;
    }

    // 보너스 번호 일치 여부 반환
    public boolean isBonusMatched(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}

