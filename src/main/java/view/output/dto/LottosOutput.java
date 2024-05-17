package view.output.dto;

import domain.Lottos;

import java.util.List;
import java.util.stream.Collectors;

public class LottosOutput {

    private final List<LottoOutput> lottoOutputs;

    public LottosOutput(List<LottoOutput> lottoOutputs) {
        this.lottoOutputs = lottoOutputs;
    }

    public static LottosOutput from(Lottos lottos) {
        return new LottosOutput(
                lottos.toList().stream()
                        .map(LottoOutput::from)
                        .collect(Collectors.toList())
        );
    }

    public String fetchLottosNumbersStr() {
        return this.lottoOutputs.stream()
                .map(LottoOutput::fetchLottoNumbersToStr)
                .collect(Collectors.joining("\n"));
    }
}
