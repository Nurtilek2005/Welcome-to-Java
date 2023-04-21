/* Задача №5
 * ===================================================
 * Вводится массив (сначала количество элементов,
 * потом сами элементы). Найдите сумму его элементов
 * с чётными индексами и выведите её. А потом выведите
 * числа, которые суммировались.
 * ===================================================
 * Sample Input: 4 - 1 2 3 4
 * Sample Output: 4 - 1 3
 */

package homework_1.task_5;

import java.util.ArrayList;
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

    public static ArrayList<Integer> getIntList() {
        int size = -1;
        int current = 0;
        Scanner iScanner = new Scanner(System.in);
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        size = getInt("Enter number list size");
        while (current < size) {
            int number = getInt("Enter '" + current + "' value");
            numberList.add(number);
            current++;
        }
        return numberList;
    }

    public static int calculateSumOfEvenIndexedNumbers(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i += 2) {
            sum += list.get(i);
        }
        return sum;
    }

    public static void printNumbers(ArrayList<Integer> list) {
        System.out.print("Numbers: ");
        for (int i = 0; i < list.size(); i += 2) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> numberList = getIntList();
        int sum = calculateSumOfEvenIndexedNumbers(numberList);
        System.out.println("Sum of even indexed numbers: " + sum);
        printNumbers(numberList);
    }
}
