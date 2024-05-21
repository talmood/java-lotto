package lotto.view.printer;

public class SecondPrizePrinter implements PrizePrinter {

    private static final String BONUS_BALL_FORMAT = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";

    @Override
    public void print(final int matchCount, final int money, final int count) {
        System.out.println(String.format(BONUS_BALL_FORMAT, matchCount, money, count));
    }
}