package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottosGenerator {

    private static final int MIN_LOTTO_NUMBER_INCLUSIVE = 1;
    private static final int MAX_LOTTO_NUMBER_INCLUSIVE = 45;
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
        List<Lotto> lottos = IntStream.range(0, this.purchaseCount.fetchPurchaseCount())
                .mapToObj(count -> this.generateLotto())
                .collect(Collectors.toList());

        return Lottos.create(lottos);
    }

    private Lotto generateLotto() {
        Collections.shuffle(totalLottoNumbers);
        List<Integer> numbers = List.copyOf(totalLottoNumbers.subList(0, LOTTO_NUMBERS_SIZE));

        return Lotto.create(numbers);
    }
}
