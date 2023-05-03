/*
Задача №3
=============================================================================================
Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке. Используйте итератор
=============================================================================================
*/

package homework_4.task_3;

import java.util.Iterator;
import java.util.LinkedList;
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

    public LinkedList<Integer> promptList(String message, int size) {
        LinkedList<Integer> numList = new LinkedList<>();
        if (!(Objects.equals(message.strip(), ""))) {
            System.out.println(message);
        }
        for (int i = 1; i <= size; i++) {
            int number = promptInt("(" + i + "/" + size + ") >>> ");
            numList.add(number);
        }
        return numList;
    }

    public int calcNumberListSum(LinkedList<Integer> numList) {
        int result = 0;
        Iterator<Integer> iterator = numList.iterator();
        while (iterator.hasNext()) {
            result += iterator.next();
        }
        return result;
    }

    public void run() {
        int size = promptInt("Введите размер списка: ");
        LinkedList<Integer> numList = promptList("Введите элементы LinkedList: ", size);
        System.out.println(calcNumberListSum(numList));
        System.out.println(numList);
    }

    public static void main(String[] args) {
        MyProgram program = new MyProgram();
        program.run();
    }
}