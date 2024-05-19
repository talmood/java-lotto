package domain;

public class AutoPurchaseCount extends PurchaseCount {
    private AutoPurchaseCount(int purchaseCount) {
        super(purchaseCount);
    }

    public static AutoPurchaseCount create(int purchaseCount) {
        return new AutoPurchaseCount(purchaseCount);
    }
}
