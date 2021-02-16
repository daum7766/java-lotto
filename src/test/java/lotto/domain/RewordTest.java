package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RewordTest {

    private Reword reword;

    @BeforeEach
    void setUp() {
        reword = Reword.THIRD;
    }

    @DisplayName("맞춘 공의 개수 테스트")
    @Test
    void hitCountTest() {
        assertThat(reword.getHitCount()).isEqualTo(5);
    }

    @DisplayName("당첨 금액 테스트")
    @Test
    void winningMoneyTest() {
        assertThat(reword.getWinningMoney()).isEqualTo(1_500_000);
    }

    @DisplayName("등수 반환 테스트")
    @Test
    void valueOfTest() {
        assertThat(Reword.valueOf(6, false)).isEqualTo(Reword.FIRST);
        assertThat(Reword.valueOf(5, true)).isEqualTo(Reword.SECOND);
        assertThat(Reword.valueOf(5, false)).isEqualTo(Reword.THIRD);
    }
}