package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class LottoResultTest {

    @DisplayName("수익률이 정확히 계산되는지 확인한다.")
    @Test
    void 수익률_계산() {
        LottoResult result = new LottoResult();
        result.add(Rank.FIFTH); // 5,000원 1개
        result.add(Rank.THIRD); // 1,500,000원 1개

        double rate = result.calculateProfit(2000); // 구입금액 2000원

        assertThat(rate).isEqualTo(75250.0);
    }
}

