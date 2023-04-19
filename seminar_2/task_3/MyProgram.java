/* Задача №2
 * ======================================================================================
 * Формат входных данных:
 * На первой строке вводится любимая буква Маши, на второй - Олега. Затем вводится
 * строка, в которой перечислены слова, которые написаны в газете.
 * Формат выходных данных:
 * На первой строчке выведите, сколько слов выписала Маша, а на второй 
 * - сколько слов выписал Олег.
 * ======================================================================================
 * Sample Input 1:
 * а
 * в
 * Автокатастрофа анклав вилка Ванна Шкаф Вагон Азов веранда
 * Sample Output 1:
 * 7
 * 5
 */

package seminar_2.task_3;

import java.util.Objects;
import java.util.Scanner;

public class MyProgram {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите IP адресс для проверки: ");
        String ipAdressStr = iScanner.nextLine();
        String[] ipAdress = ipAdressStr.split("\\.");
        if (ipAdress.length < 4 || ipAdress.length > 4) {
            System.out.println("NO");
            System.exit(1);
        }
        for (String ipPartStr: ipAdress) {
            try {
                int ipPart = Integer.parseInt(ipPartStr);
                if (ipPart > 255 || ipPart < 0) {
                    System.out.println("NO");
                    System.exit(1);
                }
            } catch (NumberFormatException exception) {
                exception.printStackTrace();
                System.exit(1);
            }
        }
        System.out.println("YES");
    }
}