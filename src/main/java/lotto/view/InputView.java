package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.util.InputParser;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return InputParser.parseAmount(Console.readLine());
    }

    public WinningLotto inputWinningLotto() {
        List<Integer> winningNumbers = getWinningNumbers();

        int bonus = getBonusNumber(winningNumbers);

        return new WinningLotto(new Lotto(winningNumbers), bonus);
    }

    private List<Integer> getWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return InputParser.parseNumbers(Console.readLine());
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return InputParser.parseBonus(Console.readLine(), winningNumbers);
    }
}

