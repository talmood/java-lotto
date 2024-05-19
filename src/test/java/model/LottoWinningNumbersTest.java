package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("당첨 결과 계산")
    @Test
    void calculateWinningResult() {
        // given
        final LottoTicket lottoTicket = new LottoTicket(List.of(
                newLottoGame(1, 2, 3, 4, 5, 6),
                newLottoGame(1, 2, 3, 4, 5, 6),
                newLottoGame(1, 2, 3, 4, 5, 7),
                newLottoGame(1, 2, 3, 4, 5, 8),
                newLottoGame(1, 2, 3, 4, 8, 9),
                newLottoGame(1, 2, 3, 8, 9, 10),
                newLottoGame(8, 9, 10, 1, 2, 3),
                newLottoGame(1, 2, 8, 9, 10, 11)
        ));

        final List<LottoNumber> prizeNumbers = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).toList();
        final LottoWinningNumbers sut = new LottoWinningNumbers(
                new LottoWinningGame(new LottoGame(prizeNumbers)),
                new LottoBonusNumber(new LottoNumber(7))
        );

        // when
        final LottoWinningResult actual = sut.calculateWinningResult(lottoTicket);

        // then
        Map<LottoPrize, Long> expected = Map.of(
                LottoPrize.FIRST, 2L,
                LottoPrize.SECOND, 1L,
                LottoPrize.THIRD, 1L,
                LottoPrize.FOURTH, 1L,
                LottoPrize.FIFTH, 2L
        );

        assertThat(actual.countByLottoPrize()).containsExactlyInAnyOrderEntriesOf(expected);
    }

    private LottoGame newLottoGame(int a, int b, int c, int d, int e, int f) {
        return new LottoGame(
                List.of(
                        new LottoNumber(a),
                        new LottoNumber(b),
                        new LottoNumber(c),
                        new LottoNumber(d),
                        new LottoNumber(e),
                        new LottoNumber(f)
                )
        );
    }

}