package domain;

public class ManualPurchaseCount extends PurchaseCount {

    private ManualPurchaseCount(int purchaseCount) {
        super(purchaseCount);
    }

    public static ManualPurchaseCount create(int purchaseCount) {
        return new ManualPurchaseCount(purchaseCount);
    }
}
