package view.output.dto;

import domain.LottoWinning;
import domain.LottoWinnings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoWinningsOutput {

    private final List<LottoWinningOutput> lottoWinningOutputs;

    public LottoWinningsOutput(List<LottoWinningOutput> lottoWinningOutputs) {
        this.lottoWinningOutputs = lottoWinningOutputs;
    }

    public static LottoWinningsOutput from(LottoWinnings lottoWinnings) {
        return new LottoWinningsOutput(
                Arrays.stream(LottoWinning.values())
                        .filter(lottoWinning -> !lottoWinning.isEqual(LottoWinning.ELSE_PLACE))
                        .map(lottoWinning ->
                                LottoWinningOutput.of(lottoWinning, lottoWinnings.countMatchLottoWinning(lottoWinning))
                        )
                        .sorted(Comparator.comparing(LottoWinningOutput::fetchWinningAmount))
                        .collect(Collectors.toList())
        );
    }

    public List<LottoWinningOutput> toList() {
        return List.copyOf(this.lottoWinningOutputs);
    }
}
