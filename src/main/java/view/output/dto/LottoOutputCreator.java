package view.output.dto;

import domain.Lotto;
import domain.Lottos;

import java.util.List;
import java.util.stream.Collectors;

public class LottoOutputCreator {

    public static LottosOutput createLottosOutput(Lottos lottos) {
        List<LottoOutput> lottoOutputs = lottos.fetchLottoList().stream()
                .map(LottoOutputCreator::createLottoOutput)
                .collect(Collectors.toList());

        return new LottosOutput(lottoOutputs);
    }

    public static LottoOutput createLottoOutput(Lotto lotto) {
        return new LottoOutput(lotto.fetchLottoNumberList());
    }
}
