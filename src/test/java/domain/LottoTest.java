package domain;

import exception.DomainValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static exception.code.ErrorCode.*;

class LottoTest {


    static Stream<Arguments> invalidLottoRange() {
        return Stream.of(
                Arguments.arguments(List.of(0, 1, 2, 3, 4, 5)),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 46)),
                Arguments.arguments(List.of(-1, -2, -3, -4, -5, -6))
        );
    }

    static Stream<Arguments> invalidLottoNumbersSize() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4)),
                Arguments.arguments(List.of(1, 2, 3, 4, 5)),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6, 7)),
                Arguments.arguments(Collections.emptyList())
        );
    }

    static Stream<Arguments> lottoNumbersAndWinning() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), 15, LottoWinning.FIRST_PLACE),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 7), 6, LottoWinning.SECOND_PLACE),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 8), 15, LottoWinning.THIRD_PLACE),
                Arguments.arguments(List.of(1, 2, 3, 4, 8, 9), 15, LottoWinning.FOURTH_PLACE),
                Arguments.arguments(List.of(1, 2, 3, 8, 9, 10), 15, LottoWinning.FIFTH_PLACE)
        );
    }

    @ParameterizedTest(name = "로또 번호 : {0}")
    @MethodSource("invalidLottoRange")
    @DisplayName("로또 번호는 범위 안에 있어야 한다.")
    void lottoInRange(List<Integer> lottoNumbers) {
        DomainValidationException domainValidationException =
                Assertions.assertThrows(DomainValidationException.class, () -> Lotto.create(lottoNumbers));

        Assertions.assertSame(domainValidationException.fetchErrorCode(), INVALID_LOTTO_NUMBER_RANGE);
    }

    @ParameterizedTest(name = "로또 번호 : {0}")
    @MethodSource("invalidLottoNumbersSize")
    @DisplayName("로또의 갯수는 정해져있어야 한다.")
    void lottoNumbersFixed(List<Integer> lottoNumbers) {
        DomainValidationException domainValidationException =
                Assertions.assertThrows(DomainValidationException.class, () -> Lotto.create(lottoNumbers));

        Assertions.assertSame(domainValidationException.fetchErrorCode(), INVALID_LOTTO_NUMBERS_SIZE);
    }

    @Test
    @DisplayName("로또는 모두 다른 값이여야 한다.")
    void lottoNumbersAllUnique() {
        List<Integer> lottoNumbers = List.of(1, 1, 2, 3, 4, 5);
        DomainValidationException domainValidationException =
                Assertions.assertThrows(DomainValidationException.class, () -> Lotto.create(lottoNumbers));

        Assertions.assertSame(domainValidationException.fetchErrorCode(), NOT_UNIQUE_LOTTO_NUMBERS);
    }

    @ParameterizedTest(name = "당첨번호 : {0}, 보너스 번호 : {1}, 당첨 : {2}")
    @MethodSource("lottoNumbersAndWinning")
    @DisplayName("로또 번호에 따라 당첨 정보를 찾는다.")
    void findLottoWinning(List<Integer> numbers, int bonus, LottoWinning lottoWinning) {
        WinningNumbers winningNumbers = WinningNumbers.create(numbers.stream()
                .map(WinningNumber::create)
                .collect(Collectors.toList())
        );
        BonusNumber bonusNumber = BonusNumber.create(bonus);
        Lotto lotto = Lotto.create(List.of(1, 2, 3, 4, 5, 6));

        Assertions.assertSame(lotto.findLottoWinning(winningNumbers, bonusNumber), lottoWinning);
    }
}