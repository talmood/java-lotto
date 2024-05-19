public class GameCountDecider {

    static final Integer LOTTO_PRICE = 1000;
    public Integer calculateGameForPrice(Integer price) {
        return price/LOTTO_PRICE;
    }
}
