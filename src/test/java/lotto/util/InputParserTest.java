package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputParserTest {
    @DisplayName("금액 입력이 숫자가 아니면 예외가 발생한다.")
    @Test
    void 금액_입력_형식_예외() {
        assertThatThrownBy(() -> InputParser.parseAmount("1000j"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("당첨 번호 입력 형식이 잘못되면 예외가 발생한다.")
    @Test
    void 당첨번호_입력_형식_예외() {
        assertThatThrownBy(() -> InputParser.parseNumbers("1,2,,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

}
