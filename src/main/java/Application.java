public class Application {
    public static void main(String[] args) {
        LottoProcessor lottoProcessor = new LottoProcessor(new InputView(), new ResultView());
        lottoProcessor.processGame();
    }
}
