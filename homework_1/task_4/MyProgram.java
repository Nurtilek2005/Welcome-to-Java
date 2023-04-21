/* Задача №4
 * ==============================================
 * Задано уравнение вида q + w = e, q, w, e >= 0
 * Некоторые цифры могут быть заменены знаком вопроса,
 * например, 2? + ?5 = 69. Требуется восстановить
 * выражение до верного равенства. Предложить хотя
 * бы одно решение или сообщить, что его нет
 * ==============================================
 */

package homework_1.task_4;

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
    
    public static int countUnknowns(int q, int w, int e) {
        int count = 0;
        if (q == -1) count++;
        if (w == -1) count++;
        if (e == -1) count++;
        return count;
    }
    
    public static int findUnknownDigit(int q, int w, int e) {
        if (q != -1 && w != -1) {
            return e - q - w;
        } else if (q != -1 && e != -1) {
            return e - q;
        } else if (w != -1 && e != -1) {
            return e - w;
        }
        return -1;
    }
    
    public static void findSolution(int q, int w, int e) {
        boolean solutionFound = false;
        for (int i = 0; i <= 9 && !solutionFound; i++) {
            for (int j = 0; j <= 9 && !solutionFound; j++) {
                int[] values = {q, w, e};
                if (q == -1) values[0] = i;
                if (w == -1) values[1] = j;
                if (e == -1) values[2] = i + j;
                if (values[0] + values[1] == values[2]) {
                    System.out.println("Solution found: " + values[0] + " + " + values[1] + " = " + values[2]);
                    solutionFound = true;
                }
            }
        }
        if (!solutionFound) {
            System.out.println("No solution");
        }
    }
    
    public static void main(String[] args) {
        int q = getInt("Enter the value of q:");
        int w = getInt("Enter the value of w:");
        int e = getInt("Enter the value of e:");
    
        int unknownCount = countUnknowns(q, w, e);
    
        if (unknownCount == 0) {
            if (q + w == e) {
                System.out.println("Equation is correct");
            } else {
                System.out.println("Equation is incorrect");
            }
        } else if (unknownCount == 1) {
            int unknownDigit = findUnknownDigit(q, w, e);
            if (q == -1) {
                System.out.println("q = " + unknownDigit);
            } else if (w == -1) {
                System.out.println("w = " + unknownDigit);
            } else {
                System.out.println("e = " + unknownDigit);
            }
        } else {
            findSolution(q, w, e);
        }
    }
}