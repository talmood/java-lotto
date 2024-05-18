package controller;

import vo.LottoNumberCollection;
import vo.LottoNumberCollectionList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualNumberRequest {
	private final int manualCount;
	private final LottoNumberCollectionList lottoNumberCollectionList;

	private static final String LOTTO_NUMBER_SPLIT_REGEX = ",";

	private ManualNumberRequest(final int manualCount, final LottoNumberCollectionList lottoNumberCollectionList) {
		this.manualCount = manualCount;
		this.lottoNumberCollectionList = lottoNumberCollectionList;
	}

	public static ManualNumberRequest of(final int manualCount, final List<String> manualNumberInputs) {
		final List<LottoNumberCollection> lottoNumberCollectionList = manualNumberInputs.stream()
			.map(manualInput -> {
				String[] splitInput = manualInput.replaceAll(" ", "").split(LOTTO_NUMBER_SPLIT_REGEX);
				return LottoNumberCollection.from(Arrays.stream(splitInput)
					.map(Integer::parseInt)
					.collect(Collectors.toList()));
			})
			.collect(Collectors.toList());

		return new ManualNumberRequest(manualCount, LottoNumberCollectionList.from(lottoNumberCollectionList));
	}

	public int getManualCount() {
		return manualCount;
	}

	public LottoNumberCollectionList getLottoNumberCollectionList() {
		return lottoNumberCollectionList;
	}
}
