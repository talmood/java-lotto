package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Console {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static String readLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
