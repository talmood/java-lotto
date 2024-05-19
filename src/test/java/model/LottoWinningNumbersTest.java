package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoWinningNumbersTest {

    @DisplayName("로또 당첨 번호와 보너스 번호는 중복될 수 없다.")
    @Test
    void should_not_be_duplicated() {
        final LottoWinningGame winningGame =
                new LottoWinningGame(LottoGame.publish(FakeLottoNumberGenerator.fromNumbers(List.of(1, 2, 3, 4, 5, 6))));
        final LottoBonusNumber bonusNumber = new LottoBonusNumber(new LottoNumber(1));

        assertThatThrownBy(() -> new LottoWinningNumbers(winningGame, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호와 보너스 번호는 중복될 수 없습니다.");
    }

}