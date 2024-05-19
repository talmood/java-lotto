import controller.LottoGameController;
import view.*;

public class Application {

    private Application() {
    }

    public static void main(String[] args) {
        final InputReader inputReader = new ConsoleReader();
        final OutputWriter outputWriter = new ConsoleWriter();

        final InputViewImpl inputView = new InputViewImpl(inputReader, outputWriter);
        final ResultView resultView = new ResultView(outputWriter);

        final LottoGameController controller = new LottoGameController(inputView, resultView);
        controller.run();
    }

}
