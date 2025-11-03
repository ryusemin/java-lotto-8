package lotto.validator;

import lotto.exception.ErrorMessage;

import java.util.HashSet;
import java.util.List;

public class LottoValidator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static void validateNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    public static void validateBonus(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS);
        }
        if (bonus < MIN_NUMBER || bonus > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE);
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SIZE);
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER);
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE);
            }
        }
    }
}
