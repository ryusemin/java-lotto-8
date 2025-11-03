package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

class WinningLottoTest {

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스_번호_중복_검증() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new WinningLotto(new Lotto(numbers), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }
}

