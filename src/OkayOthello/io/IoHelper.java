package OkayOthello.io;

import java.util.Scanner;

public class IoHelper {
    private final static Scanner scanner = new Scanner(System.in);

    public static int getNumberFromInput(int minValue, int maxValue) {
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Пожалуйста, вводите только ЧИСЛА");
                scanner.next();
                continue;
            }
            var number = scanner.nextInt();
            if (number < minValue || number > maxValue) {
                System.out.printf("Пожалуйста, введите число в диапазоне от %s до %s%n", minValue, maxValue);
                continue;
            }
            return number;
        }
    }
}
