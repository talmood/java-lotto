package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoNumbersTest {

    @Test
    @DisplayName("로또 번호 생성")
    void createLottoNumbers() {
        // given
        List<LottoNumber> numbers = Arrays.asList(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)
        );

        // when
        LottoNumbers lottoNumbers = LottoNumbers.from(numbers);

        // then
        assertEquals(numbers, lottoNumbers.getNumbers());
    }

    @Test
    @DisplayName("로또 번호 생성 실패: 로또 번호가 6개가 아닌 경우")
    void createLottoNumbersFailSize() {
        // given
        List<LottoNumber> numbers = Arrays.asList(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5)
        );

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> LottoNumbers.from(numbers));
        assertEquals("로또 번호는 6개여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("로또 번호 생성 실패: 로또 번호가 중복되는 경우")
    void createLottoNumbersFailDuplicate() {
        // given
        List<LottoNumber> numbers = Arrays.asList(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(5)
        );

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> LottoNumbers.from(numbers));
        assertEquals("로또 번호는 중복될 수 없습니다.", exception.getMessage());
    }
}