/*
Задача №1
============================================================================
Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который
вернет “перевернутый” список. Постараться не обращаться к листу по индексам.
============================================================================
*/

package homework_4.task_1;

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

    public LinkedList<Object> promptList(String message, int size) {
        Scanner iScanner = new Scanner(System.in);
        LinkedList<Object> numList = new LinkedList<>();
        if (!(Objects.equals(message.strip(), ""))) {
            System.out.println(message);
        }
        for (int i = 1; i <= size; i++) {
            System.out.print("(" + i + "/" + size + ") >>> ");
            numList.add(iScanner.nextLine());
        }
        return numList;
    }

    public LinkedList<Object> reverseList(LinkedList<Object> list) {
        LinkedList<Object> reversedList = new LinkedList<>();
        for (Object item: list) {
            reversedList.addFirst(item);
        }
        return reversedList;
    }

    public void run() {
        int size = promptInt("Введите размер списка: ");
        LinkedList<Object> numList = promptList("Введите элементы LinkedList: ", size);
        System.out.println(reverseList(numList));
    }

    public static void main(String[] args) {
        MyProgram program = new MyProgram();
        program.run();
    }
}