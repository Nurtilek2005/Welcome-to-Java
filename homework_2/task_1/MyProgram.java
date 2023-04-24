/* Задача №1
 * =================================================================================
 * Вам дается строка S и целочисленный массив индексов int index[s.length].
 * Напишите программу, которая перетасует символы в S таким образом,
 * что символ c i-й позиции переместится на индекс index[i] в результирующей строке.
 * Пример: s = “cba”, index = [3,2,1] result “abc”
 * =================================================================================
 */

package homework_2.task_1;

import java.util.Objects;
import java.util.Scanner;

public class MyProgram {
    public int promptInt(String message) {
        Scanner iScanner = new Scanner(System.in);
        while (true) {
            if (!(Objects.equals(message.strip(), ""))) {
                System.out.println(message);
            }
            System.out.print(">>> ");
            String line = iScanner.nextLine();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Неправильное число!");
            }
        }
    }

    public int[] promptNumList(String message, int size) {
        int[] numList = new int[size];
        if (!(Objects.equals(message.strip(), ""))) {
            System.out.println(message);
        }
        int index = 1;
        while (index <= size) {
            int number = promptInt("(" + index + "/" + size + ")");
            numList[index - 1] = number;
            index++;
        }
        return numList;
    }

    public void run() {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите строку\n>>> ");
        String line = iScanner.nextLine();
        StringBuilder customOrderString = new StringBuilder();
        int[] indexList = this.promptNumList("Введите индексы", line.length());
        for (int index : indexList) {
            customOrderString.append(line.charAt(index - 1));
        }
        System.out.println(customOrderString);
    }

    public static void main(String[] args) {
        MyProgram program = new MyProgram();
        program.run();
    }
}