package view;

import model.LottoBonusNumber;
import model.LottoNumber;
import utils.NumericUtils;

public class InputLottoBonusNumber {

    private final int number;

    private InputLottoBonusNumber(int number) {
        this.number = number;
    }

    public static InputLottoBonusNumber fromNumberLiteral(String bonusNumber) {
        if (!NumericUtils.isNumericString(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 숫자여야합니다.");
        }
        return new InputLottoBonusNumber(Integer.parseInt(bonusNumber));
    }

    public LottoBonusNumber toLottoBonusNumber() {
        return new LottoBonusNumber(new LottoNumber(this.number));
    }

}
