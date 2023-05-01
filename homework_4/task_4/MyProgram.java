/*
Задача №4
============================================================================
*реализовать вторую задачу через собственный класс используя в основе массив
============================================================================
*/

package homework_4.task_4;

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

    public List<Integer> promptNumArrayList(String message, int size) {
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

    public List<Integer> merge_lists(List<Integer> list_1, List<Integer> list_2) {
        List<Integer> result = new ArrayList<Integer>();
        int i = 0;
        int j = 0;

        for (int k = 0; k < list_1.size() + list_2.size(); k++) {
            if (i >= list_1.size()) {
                result.add(list_2.get(j));
                j++;
            } else if (j >= list_2.size()) {
                result.add(list_1.get(i));
                i++;
            } else if (list_1.get(i) <= list_2.get(j)) {
                result.add(list_1.get(i));
                i++;
            } else {
                result.add(list_2.get(j));
                j++;
            }
        }
        return result;
    }

    public List<Integer> merge_sort(List<Integer> unsortedNums) {
        if (unsortedNums.size() <= 1) {
            return unsortedNums;
        }
        int mid = unsortedNums.size() / 2;
        List<Integer> left = unsortedNums.subList(0, mid);
        List<Integer> right = unsortedNums.subList(mid, unsortedNums.size());
        return merge_lists(merge_sort(left), merge_sort(right));
    }

    public void run() {
        int size = promptInt("Введите размер списка: ");
        List<Integer> numArrayList = promptNumArrayList("Введите числа: ", size);
        System.out.println(merge_sort(numArrayList));
    }

    public static void main(String[] args) {
        MyProgram program = new MyProgram();
        program.run();
    }
}