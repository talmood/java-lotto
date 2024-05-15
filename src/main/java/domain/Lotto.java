package domain;

import exception.DomainValidationException;

import java.util.List;

import static exception.code.ErrorCode.*;

public class Lotto {

    private static final int MIN_LOTTO_NUMBER_INCLUSIVE = 1;
    private static final int MAX_LOTTO_NUMBER_INCLUSIVE = 45;


    private final List<Integer> lottoNumbers;


    private Lotto(List<Integer> lottoNumbers) {
        this.validateNumberRange(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto create(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private void validateNumberRange(List<Integer> lottoNumbers) {
        if(!isAllLottoNumberRange(lottoNumbers)) {
            throw new DomainValidationException(
                    INVALID_LOTTO_NUMBER_RANGE,
                    String.format("로또 번호의 범위는 %d부터 %d까지 입니다.", MIN_LOTTO_NUMBER_INCLUSIVE, MAX_LOTTO_NUMBER_INCLUSIVE)
                    );
        };
    }

    private boolean isAllLottoNumberRange(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .allMatch(this::isLottoNumberRange);
    }

    private boolean isLottoNumberRange(Integer number) {
        return number >= MIN_LOTTO_NUMBER_INCLUSIVE && number <= MAX_LOTTO_NUMBER_INCLUSIVE;
    }
}
