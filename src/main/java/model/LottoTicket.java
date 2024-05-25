package model;

import java.util.List;
import java.util.Objects;

public record LottoTicket(
        List<LottoGame> games
) {

    public int getGameSize() {
        if (Objects.isNull(this.games)) {
            return 0;
        }
        return this.games.size();
    }

}
