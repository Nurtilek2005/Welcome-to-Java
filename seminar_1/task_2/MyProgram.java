/* Задача №2
 * ==================================================================================
 * Требуется определить, можно ли от шоколадки размером n × m долек отломить k долек,
 * если разрешается сделать один разлом по прямой между дольками (то есть разломить
 * шоколадку на два прямоугольника).
 * Входные данные
 * Вводятся 3 числа: n, m и k; k не равно n × m. Гарантируется, что количество
 * долек в шоколадке не превосходит 30000.
 * Выходные данные
 * Программа должна вывести слово YES, если возможно отломить указанное число
 * долек, в противном случае вывести слово NO.
 * ==================================================================================
 * Sample Input 1: 3 2 4
 * Sample Output 1: YES
 */

package seminar_1.task_2;

import java.util.Objects;
import java.util.Scanner;

public class MyProgram {
    public static int getNum(String message) {
        Scanner iScanner = new Scanner(System.in);
        if (!Objects.equals(message.strip(), "")) System.out.print(message + ": ");
        String line = iScanner.nextLine();
        try {
            Integer.parseInt(line);
        } catch (NumberFormatException exception) {
            System.out.println("Вы ввели не целое число!");
            System.exit(1);
        }
        return Integer.parseInt(line);
    }

    public static boolean canBreakChockolate(int n, int m, int k) {
        if (k == n * m) {
            return false;
        }
        return k % n == 0 || k % m == 0;
    }

    public static void main(String[] args) {
        int number_n = getNum("Введите ширину шоколадки");
        int number_m = getNum("Введите высоту шоколадки");
        int number_k = getNum("Введите кол-во долек");
        if (canBreakChockolate(number_n, number_m, number_k)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}