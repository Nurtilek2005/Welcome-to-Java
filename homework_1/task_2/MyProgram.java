/* Задача №2
 * ==============================================
 * Вывести все простые числа от 1 до 1000
 * ==============================================
 */

package homework_1.task_2;

public class MyProgram {
    public static void printNums(int lowerBound, int upperBound) {
        if (lowerBound == upperBound - 1) {
            System.out.print(upperBound);
            return;
        }
        System.out.print(lowerBound + " ");
        printNums(lowerBound + 1, upperBound);
    }

    public static void main(String[] args) {
        printNums(1, 1000);
    }
}