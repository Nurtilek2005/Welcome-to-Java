/* Задача №0
 * =========================================================
 * Посчитайте сколько драгоценных камней в куче обычных камней
 * Пример:
 * jewels = “aB”, stones = “aaaAbbbB”
 * Результат в консоль ”a3B1”
 * =========================================================
 */

package homework_2.task_0;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class MyProgram {
    public String findJewelsInStones(String jewels, String stones) {
        StringBuilder result = new StringBuilder();
        Map<String, Integer> jewelsCount = new HashMap<>();
        for (String stone: stones.split("")) {
            for (String jewel: jewels.split("")) {
                if (!(Objects.equals(stone, jewel))) continue;
                int count = jewelsCount.getOrDefault(jewel, 0);
                jewelsCount.put(stone, count + 1);
            }
        }
        for (Map.Entry<String, Integer> item: jewelsCount.entrySet()) {
            result.append(item.getKey());
            result.append(item.getValue().toString());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите драгоценные камни");
        String jewels = iScanner.nextLine();
        System.out.println("Введите кучу камней");
        String stones = iScanner.nextLine();
        MyProgram program = new MyProgram();
        String result = program.findJewelsInStones(jewels, stones);
        System.out.println(result);
    }
}