package lotto.controller;

import lotto.domain.LottoNumber;
import lotto.domain.PurchasedLotto;

import java.util.*;

public class LottoGenerator {

    private final List<Integer> lottoNumbers;

    public LottoGenerator() {
        this.lottoNumbers = initializeLottoNumbers();
    }

    private List<Integer> initializeLottoNumbers() {
        final List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(i);
        }
        return lottoNumbers;
    }

    public List<PurchasedLotto> generatePurchasedLottos(final int purchaseCount) {
        final List<PurchasedLotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            purchasedLottos.add(generatePurchasedLotto());
        }
        return purchasedLottos;
    }

    private PurchasedLotto generatePurchasedLotto() {
        final List<Integer> shuffledNumbers = new ArrayList<>(lottoNumbers);
        Collections.shuffle(shuffledNumbers);

        final List<Integer> generatedLottoNumbers = new ArrayList<>(shuffledNumbers.subList(0, 6));
        Collections.sort(generatedLottoNumbers);

        final List<LottoNumber> lottoNumbers = generatedLottoNumbers.stream()
                .map(LottoNumber::from)
                .toList();

        return PurchasedLotto.of(new LinkedHashSet<>(lottoNumbers));
    }
}
