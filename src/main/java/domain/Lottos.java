package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos create(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public List<Lotto> toList() {
        return List.copyOf(this.lottos);
    }

    public List<LottoWinning> findLottoWinnings(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return this.lottos.stream()
                .map(lotto -> lotto.findLottoWinning(winningNumbers, bonusNumber))
                .collect(Collectors.toList());
    }
}
