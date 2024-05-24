package model;

import model.lottonumber.LottoNumberGeneratorImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketSellerTest {

    @DisplayName("로또 구매 금액 1,000원당 로또 한 게임으로 계산해서 로또 용지를 구매할 수 있다.")
    @ParameterizedTest
    @CsvSource({
            "1000,1",
            "13_000,13"
    })
    void buyLottoTicket(int purchaseAmount, int expectedGameSize) {
        // given
        final LottoPurchaseAmount amount = new LottoPurchaseAmount(purchaseAmount);

        // when
        LottoTicket actual = LottoTicketSeller.getInstance().buyLottoTicket(amount, new LottoNumberGeneratorImpl());

        // then
        assertThat(actual.getGameSize()).isEqualTo(expectedGameSize);
    }

}
