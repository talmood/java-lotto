package domain;

import exception.DomainValidationException;

import java.util.List;

import static exception.code.ErrorCode.*;

public class Lotto {

    private static final int MIN_LOTTO_NUMBER_INCLUSIVE = 0;
    private static final int MAX_LOTTO_NUMBER_INCLUSIVE = 45;


    private final List<Integer> lottoNumbers;


    public Lotto(List<Integer> lottoNumbers) {
        this.validateNumberRange();
        this.lottoNumbers = lottoNumbers;
    }

    private void validateNumberRange() {
        if(!isAllLottoNumberRange()) {
            throw new DomainValidationException(
                    INVALID_LOTTO_NUMBER_RANGE,
                    String.format("로또 번호의 범위는 %d부터 %d까지 입니다.", MIN_LOTTO_NUMBER_INCLUSIVE, MAX_LOTTO_NUMBER_INCLUSIVE)
                    );
        };
    }

    private boolean isAllLottoNumberRange() {
        return this.lottoNumbers.stream()
                .allMatch(this::isLottoNumberRange);
    }

    private boolean isLottoNumberRange(Integer number) {
        return number >= MIN_LOTTO_NUMBER_INCLUSIVE && number <= MAX_LOTTO_NUMBER_INCLUSIVE;
    }
}
