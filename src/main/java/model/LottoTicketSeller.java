package model;

import java.util.List;
import java.util.stream.IntStream;

public class LottoTicketSeller {

    private static final LottoTicketSeller INSTANCE = new LottoTicketSeller();

    private LottoTicketSeller() {
    }

    public static LottoTicketSeller getInstance() {
        return INSTANCE;
    }

    public LottoTicket buyLottoTicket(LottoPurchaseAmount purchaseAmount, LottoNumberGenerator numberGenerator) {
        List<LottoGame> games = IntStream.range(0, purchaseAmount.calculateGameSize())
                .mapToObj(gameSize -> LottoGame.publish(numberGenerator))
                .toList();

        return new LottoTicket(games);
    }

}
