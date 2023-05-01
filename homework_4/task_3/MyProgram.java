/*
Задача №3
=============================================================================================
Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке. Используйте итератор
=============================================================================================
*/

package homework_4.task_3;

import java.util.*;

public class MyProgram {
    public List<String> randomPlanets() {
        Random rand = new Random();
        String[] planetNames = new String[]{"Меркурий", "Венера", "Земля", "Марс", "Юпитер", "Сатурн", "Уран", "Нептун", "Плутон"};
        List<String> planets = new ArrayList<>();
        for (int i = 0; i < planetNames.length; i++) {
            int randIndex = rand.nextInt(0, planetNames.length);
            planets.add(planetNames[randIndex]);
        }
        return planets;
    }

    public void run() {
        List<String> planets = randomPlanets();
        Map<String, Integer> planetsCount = new HashMap<>();
        for (String planet: planets) {
            if (planetsCount.containsKey(planet)) {
                int oldCount = planetsCount.get(planet);
                planetsCount.replace(planet, oldCount + 1);
                continue;
            }
            planetsCount.put(planet, 1);
        }
        System.out.println(planets);
        System.out.println(planetsCount);
    }

    public static void main(String[] args) {
        MyProgram program = new MyProgram();
        program.run();
    }
}