package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

	private static final Scanner SCANNER = new Scanner(System.in);

	public static int inputMoney() {
		try {
			System.out.println("구매금액을 입력해 주세요.");
			return Integer.parseInt(SCANNER.nextLine());
		} catch (NumberFormatException e) {
			throw new NumberFormatException("구매금액은 숫자로 입력해 주세요.");
		}
	}

	public static int inputManualCount() {
		try {
			System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
			return Integer.parseInt(SCANNER.nextLine());
		} catch (NumberFormatException e) {
			throw new NumberFormatException("구매금액은 숫자로 입력해 주세요.");
		}
	}

	public static List<Lotto> inputManualLottoNumbers(final int counts) {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		List<Lotto> manualLottos = new ArrayList<>();
		for (int i = 0; i < counts; i++) {
			manualLottos.add(Lotto.from(inputLottoNumber()));
		}
		return manualLottos;
	}

	private static List<LottoNumber> inputLottoNumber() {
		String[] input = SCANNER.nextLine().split(",");
		return Arrays.stream(input)
			.map(String::trim)
			.map(Integer::parseInt)
			.map(LottoNumber::from)
			.collect(Collectors.toList());
	}

	public static List<LottoNumber> inputWinningLottoNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return Arrays.stream(SCANNER.nextLine().split(","))
			.map(Integer::parseInt)
			.map(LottoNumber::from)
			.collect(Collectors.toList());
	}

	public static int inputWinningBonus() {
		try {
			System.out.println("보너스 볼을 입력해 주세요.");
			return Integer.parseInt(SCANNER.nextLine());
		} catch (NumberFormatException e) {
			throw new NumberFormatException("구매금액은 숫자로 입력해 주세요.");
		}
	}
}
