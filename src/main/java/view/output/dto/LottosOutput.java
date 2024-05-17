package view.output.dto;

import domain.Lottos;

import java.util.List;
import java.util.stream.Collectors;

public class LottosOutput {

    private final List<LottoOutput> lottoOutputs;

    public LottosOutput(List<LottoOutput> lottoOutputs) {
        this.lottoOutputs = lottoOutputs;
    }

    public String fetchLottosNumbersStr() {
        return this.lottoOutputs.stream()
                .map(LottoOutput::fetchLottoNumbersToStr)
                .collect(Collectors.joining("\n"));
    }

    public static LottosOutput from(Lottos lottos) {
        List<LottoOutput> lottoOutputs = lottos.toList().stream()
                .map(LottoOutput::from)
                .collect(Collectors.toList());

        return new LottosOutput(lottoOutputs);
    }
}
