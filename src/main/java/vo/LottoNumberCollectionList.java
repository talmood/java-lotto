package vo;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberCollectionList {
	private final List<LottoNumberCollection> lottoNumberCollectionList = new ArrayList<>();

	private LottoNumberCollectionList(final List<LottoNumberCollection> lottoNumberCollectionList) {
		this.lottoNumberCollectionList.addAll(lottoNumberCollectionList);
	}

	public static LottoNumberCollectionList of(final List<LottoNumberCollection> lottoNumberCollectionList) {
		return new LottoNumberCollectionList(lottoNumberCollectionList);
	}

	public void addLottoNumberCollection(final LottoNumberCollection lottoNumberCollection) {
		this.lottoNumberCollectionList.add(lottoNumberCollection);
	}

	public List<LottoNumberCollection> getLottoNumberCollectionList() {
		return List.copyOf(this.lottoNumberCollectionList);
	}
}
