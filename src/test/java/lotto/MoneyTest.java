package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class MoneyTest {

	@Test
	void 돈은_음수가_될_수_없다() {
		assertThatThrownBy(() ->Money.from(-1))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("돈은 음수가 될 수 없습니다.");
	}

	@Test
	void 돈은_0원이_될_수_없다() {
		assertThatThrownBy(() ->Money.from(0))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("최소 1원 이상이어야 합니다.");
	}
}
