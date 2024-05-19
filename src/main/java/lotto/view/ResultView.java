package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.PurchasedLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultView {

    private static final String PURCHASE_AMOUNT_MESSAGE = "%d개를 구매했습니다.";

    private ResultView() {
    }

    public static void printPurchaseAmount(final int purchaseAmount) {
        System.out.println(String.format(PURCHASE_AMOUNT_MESSAGE, purchaseAmount));
    }

    public static void printPurchasedLottos(final List<PurchasedLotto> purchasedLottos) {
        purchasedLottos.forEach(ResultView::printPurchasedLotto);
    }

    private static void printPurchasedLotto(final PurchasedLotto purchasedLotto) {
        final List<Integer> lottoNumbers = new ArrayList<>(purchasedLotto.getLottoNumbers().stream()
                .map(LottoNumber::getNumber)
                .toList());

        Collections.sort(lottoNumbers);
        System.out.println(lottoNumbers);
    }
}