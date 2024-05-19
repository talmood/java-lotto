package vo;

import vo.enums.WinningType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningTypeCollection {
	private final List<WinningType> winningTypes = new ArrayList<>();

	private static final List<WinningType> allWinningType = List.of(
		WinningType.THREE_MATCH,
		WinningType.FOUR_MATCH,
		WinningType.FIVE_MATCH,
		WinningType.FIVE_BONUS_MATCH,
		WinningType.SIX_MATCH
	);

	public WinningTypeCollection() {}

	public void addWinningType(final WinningType winningType) {
		this.winningTypes.add(winningType);
	}

	public Map<WinningType, Long> fetchMapOfWinningTypeVsMatchCount() {
		return allWinningType.stream()
			.collect(Collectors.toMap(
				winningType -> winningType,
				winningType -> winningTypes.stream().filter(winningType::equals).count()
			));
	}

	public int calculateTotalWinningPrice() {
		return winningTypes.stream()
			.mapToInt(WinningType::getWinningPrice)
			.sum();
	}

	public List<WinningType> getAllWinningType() {
		return List.copyOf(allWinningType);
	}
}
