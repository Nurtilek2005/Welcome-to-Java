/*
Задача №1
=======================================================================
Пусть дан произвольный список целых чисел, удалить из него четные числа
=======================================================================
*/

package homework_3.task_1;

import java.util.*;

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

    public List<Integer> promptNumList(String message, int size) {
        List<Integer> numList = new ArrayList<>();
        if (!(Objects.equals(message.strip(), ""))) {
            System.out.println(message);
        }
        int index = 1;
        while (index <= size) {
            int number = promptInt("(" + index + "/" + size + ")");
            numList.add(number);
            index++;
        }
        return numList;
    }

    public void run() {
        int size = promptInt("Введите размер списка: ");
        List<Integer> numList = promptNumList("Введите числа: ", size);
        for (int i = 0; i < numList.size(); i++) {
            numList.removeIf(integer -> integer % 2 == 0);
        }
        System.out.println(numList);
    }

    public static void main(String[] args) {
        MyProgram program = new MyProgram();
        program.run();
    }
}