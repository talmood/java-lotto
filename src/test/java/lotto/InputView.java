package lotto;

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
