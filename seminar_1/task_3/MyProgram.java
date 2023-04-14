/* Задача №3
 * ==================================================================================
 * В первый день спортсмен пробежал x километров, а затем он каждый день увеличивал
 * пробег * на 10% от предыдущего значения. По данному числу y определите номер дня,
 * на который * пробег спортсмена составит не менее y километров.
 * Входные данные
 * Программа получает на вход действительные числа x и y
 * Выходные данные
 * Программа должна вывести одно натуральное число.
 * ==================================================================================
 * Sample Input 1: 10 20
 * Sample Output 1: 9
 */

package seminar_1.task_3;

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

    public static int howDaysToGetDistance(int first, int finish) {
        return howDaysToGetDistance(first, finish, 0);
    }

    public static int howDaysToGetDistance(int first, int finish, int day) {
        if (first >= finish) {
            return day;
        }
        return day + howDaysToGetDistance(first + ((first * 10) / 100), finish, day + 1);
    }

    public static void main(String[] args) {
        int firstDayDistance = getNum("Введите сколько километров пробежал в первый день");
        int needleDistance = getNum("Введите сколько километров надо пробежать");
        int result = howDaysToGetDistance(firstDayDistance, needleDistance);
        System.out.println("На " + result + " день будет преодолено " + needleDistance + " км");
    }
}