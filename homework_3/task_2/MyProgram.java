/*
Задача №2
=======================================================================
Задан целочисленный список ArrayList. Найти минимальное, максимальное и
среднее арифметическое из этого списка. Collections.max()
=======================================================================
*/

package homework_3.task_2;

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

    public ArrayList<Integer> promptNumArrayList(String message, int size) {
        ArrayList<Integer> numList = new ArrayList<>();
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

    public double getAverageInNumArrayList(ArrayList<Integer> numArrayList) {
        double average = 0;
        for (int number: numArrayList) {
            average += number;
        }
        return average / numArrayList.size();
    }

    public void run() {
        int size = promptInt("Введите размер списка: ");
        ArrayList<Integer> numArrayList = promptNumArrayList("Введите числа: ", size);
        int maxInNums = Collections.max(numArrayList);
        int minInNums = Collections.min(numArrayList);
        double avgInNums = getAverageInNumArrayList(numArrayList);
        System.out.println("MIN ELEMENT IN LIST: " + minInNums);
        System.out.println("MAX ELEMENT IN LIST: " + maxInNums);
        System.out.println("AVG ELEMENT IN LIST: " + avgInNums);
    }

    public static void main(String[] args) {
        MyProgram program = new MyProgram();
        program.run();
    }
}