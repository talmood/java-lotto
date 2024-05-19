package view;

import model.LottoGame;
import model.LottoNumber;
import model.LottoTicket;

import java.util.List;

public class ResultView {

    private final OutputWriter outputWriter;

    public ResultView(OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
    }

    public void showPurchasedLottoTicket(LottoTicket lottoTicket) {
        outputWriter.writeMessage("%d개를 구매했습니다.".formatted(lottoTicket.getGameSize()));

        final List<LottoGame> games = lottoTicket.games();
        games.forEach(game -> outputWriter.writeMessage(formatLottoGameOutput(game)));
    }

    private String formatLottoGameOutput(LottoGame game) {
        return game.numbers().stream()
                .map(LottoNumber::number)
                .toList()
                .toString();
    }

}
