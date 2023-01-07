package util;

import exceptions.BoardException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

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

    public static Integer askColumnUtil(String message) {
        System.out.printf("%s%n# : ", message);
        Scanner sc = new Scanner(System.in);
        Integer number;
        do {
            try {
                number = sc.nextInt();
                if (number < 0 || number > 9) {
                    throw new BoardException("Coluna incorreta, digite uma opção entre 0,1,2,3,4,5,6,7,8,9");
                }
            } catch (BoardException e) {
                sc.nextLine();
                System.out.println(e.getMessage());
                number = null;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Coluna incorreta, digite apenas NUMEROS entre 0,1,2,3,4,5,6,7,8,9");
                number = null;
            }

        } while (number == null);
        return number;
    }

    public static ArrayList<String> generateRandomPositions(int nBarcos, int nbuttons) {
        ArrayList<String> randomList = new ArrayList<>();
        for (int i = 0; i < nBarcos; i++) {
            int randomNumber= Util.intAleatorio(0, nbuttons);
            String position = String.valueOf(randomNumber);
            if (! randomList.contains(position)) {
                randomList.add(position);
            } else {
                i = i - 1;
            }
        }
        return randomList;
    }
    
}