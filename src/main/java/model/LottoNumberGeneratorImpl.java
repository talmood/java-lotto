package model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static model.LottoGame.LOTTO_NUMBER_SIZE;
import static model.LottoNumber.MAX_NUMBER;
import static model.LottoNumber.MIN_NUMBER;

public class LottoNumberGeneratorImpl implements LottoNumberGenerator {

    @Override
    public List<LottoNumber> generate() {
        final List<Integer> lottoNumberCandidates = IntStream.range(MIN_NUMBER, MAX_NUMBER + 1)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(lottoNumberCandidates);

        return lottoNumberCandidates.subList(0, LOTTO_NUMBER_SIZE)
                .stream()
                .map(LottoNumber::new)
                .toList();
    }

}
