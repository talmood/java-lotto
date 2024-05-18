package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static constant.LottoConstants.MAX_LOTTO_NUMBER_INCLUSIVE;
import static constant.LottoConstants.MIN_LOTTO_NUMBER_INCLUSIVE;

public class LottosGenerator {

    private static final int LOTTO_NUMBERS_SIZE = 6;

    private static final List<Integer> totalLottoNumbers =
            IntStream.range(MIN_LOTTO_NUMBER_INCLUSIVE, MAX_LOTTO_NUMBER_INCLUSIVE)
                    .boxed()
                    .collect(Collectors.toList());

    private final PurchaseCount purchaseCount;

    public LottosGenerator(PurchaseCount purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public Lottos generate() {
        return Lottos.create(
                IntStream.range(0, this.purchaseCount.fetchPurchaseCount())
                        .mapToObj(count -> this.generateLotto())
                        .collect(Collectors.toList())
        );
    }

    private Lotto generateLotto() {
        Collections.shuffle(totalLottoNumbers);
        List<Integer> lottoNumbers = totalLottoNumbers.subList(0, LOTTO_NUMBERS_SIZE);
        Collections.sort(lottoNumbers);

        return Lotto.create(List.copyOf(totalLottoNumbers.subList(0, LOTTO_NUMBERS_SIZE)));
    }
}
