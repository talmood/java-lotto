package model;

import java.util.HashMap;
import java.util.Map;

public class LottoNumberPool {

    private static final LottoNumberPool INSTANCE = new LottoNumberPool();

    private final Map<Integer, LottoNumber> pool = new HashMap<>();

    private LottoNumberPool() {
    }

    public static LottoNumberPool getInstance() {
        return INSTANCE;
    }

    public LottoNumber getNumberBy(int number) {
        if (this.pool.containsKey(number)) {
            return this.pool.get(number);
        }

        final LottoNumber lottoNumber = new LottoNumber(number);
        this.pool.put(number, lottoNumber);
        return lottoNumber;
    }

}
