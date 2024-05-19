package model;

import java.util.List;
import java.util.Objects;

public class LottoTicket {

    private final List<LottoGame> games;

    public LottoTicket(List<LottoGame> games) {
        this.games = games;
    }

    public int getGameSize() {
        if (Objects.isNull(this.games)) {
            return 0;
        }
        return this.games.size();
    }

}
