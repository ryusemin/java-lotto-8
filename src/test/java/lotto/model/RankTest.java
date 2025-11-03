package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class RankTest {

    @DisplayName("6개 번호 일치 시 1등을 반환한다.")
    @Test
    void 랭크_1등() {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
    }

    @DisplayName("5개 번호와 보너스 번호 일치 시 2등을 반환한다.")
    @Test
    void 랭크_2등() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("3개 번호 일치 시 5등을 반환한다.")
    @Test
    void 랭크_5등() {
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
    }
}

