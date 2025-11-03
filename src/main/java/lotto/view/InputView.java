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
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().split(",");
        List<Integer> numbers = Arrays.stream(input)
                .map(Integer::parseInt)
                .toList();

        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());
        return new WinningLotto(new Lotto(numbers), bonus);
    }
}

