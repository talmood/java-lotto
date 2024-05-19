import java.awt.print.Pageable;
import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public void guidePurchasePrice() {
        System.out.println("구매금액을 입력해주세요");
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
