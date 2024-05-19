package view.input.dto;

import domain.Lotto;

import java.util.List;

public class ManualLottoNumberInput {

    private final List<Integer> lottoNumbers;

    public ManualLottoNumberInput(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto toLotto() {
        return Lotto.create(lottoNumbers);
    }
}

