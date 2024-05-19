package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PurchasedLottoTest {

    @Test
    @DisplayName("로또 번호 생성")
    void createPurchasedLotto() {
        // given
        List<LottoNumber> numbers = Arrays.asList(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)
        );
        LottoNumbers lottoNumbers = LottoNumbers.from(numbers);

        // when
        PurchasedLotto purchasedLotto = PurchasedLotto.from(lottoNumbers);

        // then
        assertEquals(lottoNumbers, purchasedLotto.getLottoNumbers());
    }

    @Test
    @DisplayName("로또 번호 생성 실패: 로또 번호가 null인 경우")
    void createPurchasedLottoFailNull() {
        // given
        LottoNumbers lottoNumbers = null;

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> PurchasedLotto.from(lottoNumbers));
        assertEquals("lotto numbers must not be null", exception.getMessage());
    }
}