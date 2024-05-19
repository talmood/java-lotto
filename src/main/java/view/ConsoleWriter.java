package view;

public class ConsoleWriter implements OutputWriter {

    @Override
    public void writeMessage(String message) {
        System.out.println(message);
    }

}
