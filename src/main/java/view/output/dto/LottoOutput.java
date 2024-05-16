package view.output.dto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoOutput {

    private final List<Integer> lottoNumbers;

    public LottoOutput(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public String fetchLottoNumbersStr() {
        String lottoNumbersStr = this.lottoNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        return "[" + lottoNumbersStr + "]";
    }
}
