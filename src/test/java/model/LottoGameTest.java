package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @DisplayName("로또 게임 발행 시 로또 숫자는 6개이다.")
    @Test
    void publish() {
        final LottoGame actual = LottoGame.publish();
        assertThat(actual.numbers()).hasSize(6);
    }

}
