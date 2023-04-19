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

package seminar_2.task_2;

import java.util.Objects;
import java.util.Scanner;

public class MyProgram {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите любимую букву Маши: ");
        String mashaLetter = iScanner.nextLine().toLowerCase();
        System.out.print("Введите любимую букву Олега: ");
        String olegLetter = iScanner.nextLine().toLowerCase();
        System.out.print("Введите слова из газеты: ");
        String words = iScanner.nextLine();

        int mashaCount = 0;
        int olegCount = 0;

        for (String word : words.split(" ")) {
            boolean mashaFound = false;
            boolean olegFound = false;
            for (String letter: word.split("")) {
                if (Objects.equals(mashaLetter, letter.toLowerCase()) && !(mashaFound)) {
                    mashaFound = true;
                    mashaCount++;
                }
                if (Objects.equals(olegLetter, letter.toLowerCase()) && !(olegFound)) {
                    olegFound = true;
                    olegCount++;
                }
            }
        }
        System.out.println(mashaCount);
        System.out.println(olegCount);
    }
}