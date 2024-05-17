package domain;

import exception.DomainValidationException;
import exception.code.ErrorCode;
import util.CollectionUtils;

import java.util.List;

public class LottoWinnings {

    private final List<LottoWinning> lottoWinnings;

    private LottoWinnings(List<LottoWinning> lottoWinnings) {
        this.validateNotEmpty(lottoWinnings);
        this.lottoWinnings = lottoWinnings;
    }

    public static LottoWinnings create(List<LottoWinning> lottoWinnings) {
        return new LottoWinnings(lottoWinnings);
    }

    private void validateNotEmpty(List<LottoWinning> lottoWinnings) {
        if (CollectionUtils.isEmpty(lottoWinnings)) {
            throw new DomainValidationException(ErrorCode.COLLECTION_MUST_NOT_BE_EMPTY, "당첨 정보는 null이거나 empty이면 안됩니다.");
        }
    }
}
