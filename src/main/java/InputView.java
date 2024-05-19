import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public void guideToPutPurchasePrice() {
        System.out.println("구매금액을 입력해주세요");
    }
    public void guideToPutWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void guideToPutBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public String acceptInput() {
        return scanner.nextLine();
    }

    public Integer validatePurchasePrice(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요");
            return null;
        }
    }


}
