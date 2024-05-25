package view;

import model.LottoBonusNumber;
import model.LottoPurchaseAmount;
import model.LottoWinningGame;

public interface InputView {

    LottoPurchaseAmount inputLottoPurchaseAmount();

    LottoWinningGame inputLottoWinningGame();

    LottoBonusNumber inputLottoBonusNumber();

}
