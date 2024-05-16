package view.output.dto;

import domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottosOutput {

    private final List<LottoOutput> lottoOutputs;

    public LottosOutput(List<LottoOutput> lottoOutputs) {
        this.lottoOutputs = lottoOutputs;
    }

    public String fetchLottosNumbersStr() {
        return this.lottoOutputs.stream()
                .map(LottoOutput::fetchLottoNumbersStr)
                .collect(Collectors.joining("\n"));
    }
}
