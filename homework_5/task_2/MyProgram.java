/*
Задача №2
=================================================================================================
Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина,
Анна Крутова, Иван Юрин,Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова,
Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.
=================================================================================================
*/

package homework_5.task_2;

import java.util.*;
import java.util.Map.Entry;

public class MyProgram {
    public void run() {
        String[] workers = new String[]{
                "Иван Иванов",
                "Светлана Петрова",
                "Кристина Белова",
                "Анна Мусина",
                "Анна Крутова",
                "Иван Юрин",
                "Петр Лыков",
                "Павел Чернов",
                "Петр Чернышов",
                "Мария Федорова",
                "Марина Светлова",
                "Мария Савина",
                "Мария Рыкова",
                "Марина Лугова",
                "Анна Владимирова",
                "Иван Мечников",
                "Петр Петин",
                "Иван Ежов"
        };
        Map<String, Integer> namesCount = new TreeMap<>();
        for (String worker : workers) {
            String workerName = worker.split(" ")[0];
            namesCount.put(workerName, namesCount.getOrDefault(workerName, 0) + 1);
        }
        Map<String, Integer> sortedNames = sortNamesByFavorite(namesCount);
        System.out.println(sortedNames);
    }

    public Map<String, Integer> sortNamesByFavorite(Map<String, Integer> namesList) {
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;
        Map<String, Integer> sortedNames = new LinkedHashMap<>();
        for (int i = 0; i < namesList.size(); i++) {
            for (Entry<String, Integer> item : namesList.entrySet()) {
                if (sortedNames.containsKey(item.getKey())) {
                    continue;
                }
                if (maxValue < item.getValue()) {
                    maxKey = item.getKey();
                    maxValue = item.getValue();
                }
            }
            if (sortedNames.containsKey(maxKey)) {
                maxValue = Integer.MIN_VALUE;
                maxKey = null;
                continue;
            }
            sortedNames.put(maxKey, maxValue);
            maxValue = Integer.MIN_VALUE;
            maxKey = null;
        }
        return sortedNames;
    }

    public static void main(String[] args) {
        MyProgram program = new MyProgram();
        program.run();
    }
}