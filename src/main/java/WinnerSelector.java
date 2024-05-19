import java.util.List;

public class WinnerSelector {
    private final Winners winners;

    public Winners getWinners() {
        return winners;
    }

    public WinnerSelector(Lotto lotto, WinningLottoNumber winningLottoNumber) {
        int firstWinner = 0;
        int secondWinner = 0;
        int thirdWinner = 0;
        int fourthWinner = 0;
        int fifthWinner = 0;

        List<Integer> winningNumbers = winningLottoNumber.getWinningNumbers();
        Integer bonusNumber = winningLottoNumber.getBonusNumber();

        for (LottoGame lottoGame : lotto.getLottoGames()) {
            Integer matchCount = 0;

            List<Integer> gameNumbers = lottoGame.getGameNumbers();
            matchCount = findWinningNumberInGameNumber(matchCount, winningNumbers, gameNumbers);

            firstWinner = getFirstWinner(firstWinner, matchCount);
            secondWinner = getSecondWinner(secondWinner, bonusNumber, matchCount, gameNumbers);
            thirdWinner = getThirdWinner(thirdWinner, bonusNumber, matchCount, gameNumbers);
            fourthWinner = getFourthWinner(fourthWinner, matchCount);
            fifthWinner = getFifthWinner(fifthWinner, matchCount);
        }
        this.winners = new Winners(firstWinner, secondWinner, thirdWinner, fourthWinner, fifthWinner);
    }

    private int getFifthWinner(int fifthWinner, Integer matchCount) {
        if (matchCount == 3) {
            fifthWinner++;
        }
        return fifthWinner;
    }

    private int getFourthWinner(int fourthWinner, Integer matchCount) {
        if (matchCount == 4) {
            fourthWinner++;
        }
        return fourthWinner;
    }

    private int getThirdWinner(int thirdWinner, Integer bonusNumber, Integer matchCount, List<Integer> gameNumbers) {
        if (matchCount == 5 && !isBonusNumberMatch(gameNumbers, bonusNumber)) {
            thirdWinner++;
        }
        return thirdWinner;
    }

    private int getSecondWinner(int secondWinner, Integer bonusNumber, Integer matchCount, List<Integer> gameNumbers) {
        if (matchCount == 5 && isBonusNumberMatch(gameNumbers, bonusNumber)) {
            secondWinner++;
        }
        return secondWinner;
    }

    private int getFirstWinner(int firstWinner, Integer matchCount) {
        if (matchCount == 6) {
            firstWinner++;
        }
        return firstWinner;
    }


    private boolean isBonusNumberMatch(List<Integer> gameNumbers, Integer bonusNumber) {
        return gameNumbers.contains(bonusNumber);
    }

    private Integer findWinningNumberInGameNumber(Integer matchCount, List<Integer> winningNumbers, List<Integer> gameNumbers) {
        for (Integer number : gameNumbers) {
            matchCount = increaseMatchCountIfIncludeGameNumber(matchCount, winningNumbers, number);
        }
        return matchCount;
    }

    private Integer increaseMatchCountIfIncludeGameNumber(Integer matchCount, List<Integer> winningNumbers, Integer number) {
        if (winningNumbers.contains(number)) {
            matchCount++;
        }
        return matchCount;
    }

}
