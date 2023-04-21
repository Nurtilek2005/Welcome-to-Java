/* Задача №6
 * =========================================================
 * Дан список. Выведите те его элементы, которые встречаются
 * в списке только один раз. Элементы нужно выводить в том
 * порядке, в котором они встречаются в списке.
 * =========================================================
 * Sample Input: 6 - 1 2 2 3 3 3
 * Sample Output: 1
 */

package homework_1.task_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MyProgram {
    public static int getInt(String message) {
        Scanner iScanner = new Scanner(System.in);
        while (true) {
            if (message != null)
                System.out.println(message);
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

    public static void main(String[] args) {
        ArrayList<Integer> numberList = getIntList();
        HashMap<Integer, Integer> uniqueMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < numberList.size(); i++) {
            int number = numberList.get(i);
            if (uniqueMap.containsKey(number)) {
                uniqueMap.put(number, uniqueMap.get(number) + 1);
            } else {
                uniqueMap.put(number, 1);
            }
        }
        for (int i = 0; i < numberList.size(); i++) {
            int number = numberList.get(i);
            if (uniqueMap.get(number) == 1) {
                System.out.println(number);
            }
        }
    }
}
