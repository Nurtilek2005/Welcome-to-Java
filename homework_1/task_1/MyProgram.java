/* Задача №1
 * ==============================================
 * Вычислить n-ое треугольного число (сумма чисел
 * от 1 до n), n! (произведение чисел от 1 до n)
 * ==============================================
 */

package homework_1.task_1;

import java.util.Scanner;

public class MyProgram {
    public static int getInt(String message) {
        Scanner iScanner = new Scanner(System.in);
        while (true) {
            if (message != null) System.out.println(message);
            String intoLine = iScanner.nextLine();
            try {
                int number = Integer.parseInt(intoLine);
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect number!");
                continue;
            }
        }
    }

    public static void main(String[] args) {
        int result = 0;
        int number = getInt("Enter number");
        for (int i = 1; i <= number; i++) {
            result += i;
        }
        System.out.println(result);
    }
}