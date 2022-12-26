package util;

import java.util.Random;

public class Util {
    public static int intAleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
