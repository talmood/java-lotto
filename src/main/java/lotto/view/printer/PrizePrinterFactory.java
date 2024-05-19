package lotto.view.printer;

import lotto.domain.prize.Prize;

import java.util.EnumMap;
import java.util.Map;

public class PrizePrinterFactory {
    private static final Map<Prize, PrizePrinter> printers = new EnumMap<>(Prize.class);

    private PrizePrinterFactory() {}

    static {
        printers.put(Prize.SECOND, new SecondPrizePrinter());
    }

    public static PrizePrinter generatePrinter(final Prize prize) {
        return printers.getOrDefault(prize, new DefaultPrizePrinter());
    }
}