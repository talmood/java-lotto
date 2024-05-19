import java.util.List;

public class ResultView {
    public void printPurchasedGameCount(Integer gameCount) {
        System.out.println(gameCount + "개를 구매했습니다.");
    }

    public void printLottoGameNumbers(Lotto lotto) {
        List<LottoGame> lottoGames = lotto.getLottoGames();
        for (int i = 0; i < lottoGames .size(); i++) {
            System.out.println(lottoGames.get(i));
        }
    }

    public void printWinnerStatisticsMessage() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public void printWinnerStatistics(Winners winners, ProfitCalculator profitCalculator) {
        float profit = profitCalculator.getProfit();

        System.out.println("3개 일치 (" + profitCalculator.FIFTH_PRIZE + "원)- " + winners.getFifthWinner()+"개");
        System.out.println("4개 일치 (" + profitCalculator.FOURTH_PRIZE + "원)- " + winners.getFourthWinner()+"개");
        System.out.println("5개 일치 (" + profitCalculator.THIRD_PRIZE + "원)- " + winners.getThirdWinner()+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + profitCalculator.SECOND_PRIZE + "원)- " + winners.getSecondWinner()+"개");
        System.out.println("6개 일치 (" + profitCalculator.FIRST_PRIZE + "원)- " + winners.getFirstWinner()+"개");
        System.out.println("profit = " + profit);
        System.out.println(String.format("총 수익률은 %.2f 입니다.", profit));
    }
}
