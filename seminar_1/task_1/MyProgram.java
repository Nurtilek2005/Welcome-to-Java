/* Задача №1
 * ======================================================================================
 * Улитка ползёт по вертикальному шесту высотой h метров, поднимаясь за день на a метров,
 * а за ночь спускаясь на b метров. На какой день улитка доползёт до вершины шеста?
 * Программа получает на вход натуральные числа h, a, b. Гарантируется, что a>b.
 * Программа должна вывести одно натуральное число.
 * ======================================================================================
 * Sample Input 1: 10, 3, 2
 * Sample Output 1: 8
 */

package seminar_1.task_1;

import java.util.Objects;
import java.util.Scanner;

class MyProgram {
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

    public static void main(String[] args) {
        int height = getNum("Введите высоту шеста");
        int dayUp = getNum("Введите сколько метров поднимается за день");
        int nightDown = getNum("Введите сколько метров спускается за ночь");
        int finishDay = 0;
        for (int i = 0; i < height; i += dayUp) {
            if (i % 2 != 0) {
                finishDay = i;
                i -= nightDown;
                continue;
            }
            finishDay = i;
        }
        System.out.println("На " + finishDay + " день улитка доплзет до вершины шеста");
    }
}