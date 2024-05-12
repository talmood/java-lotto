package vo;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberCollection {

	private final List<Integer> pickLottoNumbers = new ArrayList<>();

	private LottoNumberCollection(final List<Integer> pickLottoNumbers) {
		this.pickLottoNumbers.addAll(pickLottoNumbers);
	}

	public static LottoNumberCollection of(final List<Integer> pickLottoNumbers) {
		return new LottoNumberCollection(pickLottoNumbers);
	}

	public List<Integer> getPickLottoNumbers() {
		return List.copyOf(this.pickLottoNumbers);
	}
}
