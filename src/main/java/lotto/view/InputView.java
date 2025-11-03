package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.WinningLotto;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public WinningLotto inputWinningLotto() {
        List<Integer> winningNumbers = getWinningNumbers();
        int bonus = getBonusNumber(winningNumbers);
        return new WinningLotto(new Lotto(winningNumbers), bonus);
    }

    private List<Integer> getWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        try {
            String[] input = Console.readLine().split(",");
            List<Integer> numbers = Arrays.stream(input)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
            Lotto.validate(numbers);
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 형식에 맞게 입력하세요. 예) 1,2,3,4,5,6");
        }
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        try {
            int bonus = Integer.parseInt(Console.readLine().trim());

            if (winningNumbers.contains(bonus)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }

            if (bonus < 1 || bonus > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이여야 합니다.");
            }
            return bonus;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 형식에 맞게 입력하세요. 예) 7");
        }
    }
}

