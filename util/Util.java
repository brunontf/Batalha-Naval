package util;

import java.util.Random;

public class Util {
    public static int intAleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    public static int returnInt(String letra) {
        letra.toUpperCase();
        Character c = letra.charAt(0);
        int row = Character.getNumericValue(c);
        return row-10;
    }
}
