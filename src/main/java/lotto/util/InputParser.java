package lotto.util;

import lotto.exception.ErrorMessage;
import lotto.validator.LottoValidator;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public static int parseAmount(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_FORMAT);
        }
    }

    public static List<Integer> parseNumbers(String input) {
        try {
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();

            LottoValidator.validateNumbers(numbers);
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT);
        }
    }

    public static int parseBonus(String input, List<Integer> winningNumbers) {
        try {
            int bonus = Integer.parseInt(input.trim());
            LottoValidator.validateBonus(winningNumbers, bonus);
            return bonus;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_FORMAT);
        }
    }
}
