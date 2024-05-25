package model;

import model.lottonumber.LottoNumber;
import model.lottonumber.LottoNumberGeneratorImpl;
import model.lottonumber.LottoNumberPool;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameTest {

    @DisplayName("로또 게임 발행 시 로또 숫자는 6개이다.")
    @Test
    void publish() {
        final LottoGame actual = LottoGame.publish(new LottoNumberGeneratorImpl());
        assertThat(actual.numbers()).hasSize(6);
    }

    @DisplayName("로또 게임 숫자는 서로 다른 6개로 이루어져야한다.")
    @Test
    void validateNumberSize() {
        final List<LottoNumber> numbers = Stream.of(1, 2, 3, 4, 5, 5).map(number -> LottoNumberPool.getInstance().getNumberBy(number)).toList();
        assertThatThrownBy(() -> new LottoGame(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 게임 숫자는 서로 다른 6개로 이루어져야합니다.");
    }

}
