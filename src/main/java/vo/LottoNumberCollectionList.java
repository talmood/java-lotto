package vo;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberCollectionList {
	private final List<LottoNumberCollection> lottoNumberCollectionList = new ArrayList<>();

	private LottoNumberCollectionList(final List<LottoNumberCollection> lottoNumberCollectionList) {
		this.lottoNumberCollectionList.addAll(lottoNumberCollectionList);
	}

	public static LottoNumberCollectionList from(final List<LottoNumberCollection> lottoNumberCollectionList) {
		return new LottoNumberCollectionList(lottoNumberCollectionList);
	}

	public void addLottoNumberCollection(final LottoNumberCollection lottoNumberCollection) {
		this.lottoNumberCollectionList.add(lottoNumberCollection);
	}

	public void addAllLottoNumberCollection(final LottoNumberCollectionList lottoNumberCollectionList) {
		this.lottoNumberCollectionList.addAll(lottoNumberCollectionList.getLottoNumberCollectionList());
	}

	public List<LottoNumberCollection> getLottoNumberCollectionList() {
		return List.copyOf(this.lottoNumberCollectionList);
	}
}
