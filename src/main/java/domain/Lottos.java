package domain;

import view.output.dto.LottoOutput;
import view.output.dto.LottosOutput;

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

    public List<Lotto> fetchLottoList() {
        return List.copyOf(this.lottos);
    }
}
