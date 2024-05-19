package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("1 미만 또는 45 초과의 숫자가 주어질 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void LottoNumber(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

}