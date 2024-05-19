package view.input.dto;

import domain.Lottos;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoNumbersInput {

    private final List<ManualLottoNumberInput> lottos;

    public ManualLottoNumbersInput(List<ManualLottoNumberInput> lottos) {
        this.lottos = lottos;
    }

    public Lottos toLottos() {
        return Lottos.create(
                this.lottos.stream()
                        .map(ManualLottoNumberInput::toLotto)
                        .collect(Collectors.toList())
        );
    }

}
