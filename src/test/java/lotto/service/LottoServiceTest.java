package lotto.service;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoServiceTest {
    @DisplayName("로또 구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입금액_검증_예외() {
        LottoService service = new LottoService();
        assertThatThrownBy(() -> service.buyLottos(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원 단위");
    }

    @DisplayName("10000원을 입력하면 10개의 로또가 생성된다.")
    @Test
    void 구입금액에_따라_로또개수_생성() {
        LottoService service = new LottoService();
        List<Lotto> lottos = service.buyLottos(10000);
        assertThat(lottos).hasSize(10);
    }


}
