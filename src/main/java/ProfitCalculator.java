public class ProfitCalculator {

    final static Integer FIRST_PRIZE = 2000000000;
    final static Integer SECOND_PRIZE = 30000000;
    final static Integer THIRD_PRIZE = 1500000;
    final static Integer FOURTH_PRIZE = 50000;
    final static Integer FIFTH_PRIZE = 5000;

    private float profit = 0;

    public ProfitCalculator(Winners winners, Integer investMoney) {
        Integer totalWinningMoney =
                winners.getFirstWinner() * FIRST_PRIZE
                + winners.getSecondWinner() * SECOND_PRIZE
                + winners.getThirdWinner() * THIRD_PRIZE
                + winners.getFourthWinner() * FOURTH_PRIZE
                + winners.getFifthWinner() * FIFTH_PRIZE;

          this.profit = totalWinningMoney.floatValue() / investMoney.floatValue();
    }

    public float getProfit() {
        return profit;
    }
}
