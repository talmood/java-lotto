package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("로또 번호 생성")
    @ValueSource(ints = {1, 45})
    void createLottoNumber(int number) {
        // when
        LottoNumber lottoNumber = LottoNumber.from(number);

        // then
        assertEquals(number, lottoNumber.getNumber());
    }

    @ParameterizedTest
    @DisplayName("로또 번호 생성 실패")
    @ValueSource(ints = {0, 46})
    void createLottoNumberFail(int number) {
        // when & then
        assertThrows(IllegalArgumentException.class, () -> LottoNumber.from(number))
                .getMessage().equals("로또 번호는 1부터 45까지의 숫자만 가능합니다.");
    }
}