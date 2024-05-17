package view.output.dto;

import domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoOutput {

    private final List<Integer> lottoNumbers;

    public LottoOutput(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public String fetchLottoNumbersToStr() {
        String lottoNumbersStr = this.lottoNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        return "[" + lottoNumbersStr + "]";
    }

    public static LottoOutput from(Lotto lotto) {
        return new LottoOutput(lotto.fetchLottoNumberList());
    }
}
