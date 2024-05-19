package lotto.controller;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.PurchasedLotto;

import java.util.*;

public class LottoGenerator {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> candidateLottoNumbers;

    public LottoGenerator() {
        this.candidateLottoNumbers = initializeCandidateNumbers();
    }

    private List<Integer> initializeCandidateNumbers() {
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
        final List<Integer> shuffledNumbers = new ArrayList<>(candidateLottoNumbers);
        Collections.shuffle(shuffledNumbers);

        final List<LottoNumber> lottoNumbers = shuffledNumbers.stream()
                .limit(LOTTO_NUMBER_SIZE)
                .map(LottoNumber::from)
                .toList();

        return PurchasedLotto.from(LottoNumbers.from(lottoNumbers));
    }
}
