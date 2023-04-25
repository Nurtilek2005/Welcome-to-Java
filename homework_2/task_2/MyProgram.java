/* Задача №2
 * =====================================================================================================================
 * На первой строке записывается натуральное число n - количество строчек в книге. Затем вводится n строк - строки книги
 * потом вводится натуральное число m - количество продуктов, на которые у человека аллергия. Потом вводится m строк -
 * вида "продукт1 - продукт2", где продукт1 - продукт, на который у человека аллергия и продукт2 - продукт, на который
 * следует заменить продукт1. Гарантируется что любой продукт состоит из 1 слова. название продуктов написаны строчными
 * буквами. Гарантируется, что продукты, на которые нужно выполнить замену, не встречаются изначально в тексте.
 * Выходные данные:
 * Замените все продукты в поваренной книге Васи и выведите их построчно на экран. На окончания не обращайте внимание.
 * Если продукт, который следует заменить написан с большой буквы, то и замена тоже должна начинаться с большой буквы!
 * Sample Input:
 * 2
 * Рецепт 1. Арахис 100гр, мороженое 200гр. Возьмите арахис и измелчите его. Посыпьте измельчённый арахис на мороженое.
 * Рецепт 2. Клубника 100гр, сгущенка 3кг. Смешать, есть) Радоваться жизни.
 * 3
 * арахис - колбаса
 * клубника - вишня
 * сгущенка - молоко
 * Sample Output:
 * Рецепт 1. Колбаса 100гр, мороженое 200гр. Возьмите колбаса и измелчите его. Посыпьте измельчённый колбаса на мороженое
 * =====================================================================================================================
 */

package homework_2.task_2;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

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

    public void run() {
        ArrayList<String> kitchenBook = new ArrayList<>();
        ArrayList<String[]> replaces = new ArrayList<>();
        Scanner iScanner = new Scanner(System.in);
        int receiptsCount = promptInt("Введите кол-во строк");
        for (int i = 1; i <= receiptsCount; i++) {
            System.out.print(i + " строка " + ">>> ");
            String receipt = iScanner.nextLine();
            kitchenBook.add(receipt);
        }
        int productsCount = promptInt("Введите кол-во продуктов");
        for (int i = 1; i <= productsCount; i++) {
            System.out.print(i + " продукты " + ">>> ");
            String[] products = iScanner.nextLine().split(" - ");
            replaces.add(products);
        }
        for (int i = 0; i < receiptsCount; i++) {
            String receipt = kitchenBook.get(i);
            for (String[] products : replaces) {
                String allergy = products[0];
                String replace = products[1];
                allergy = allergy.substring(0, 1).toUpperCase() + allergy.substring(1);
                replace = replace.substring(0, 1).toUpperCase() + replace.substring(1);
                receipt = receipt.replace(allergy.toLowerCase(), replace.toLowerCase());
                receipt = receipt.replace(allergy, replace);
            }
            kitchenBook.set(i, receipt);
        }
        System.out.println(kitchenBook);
    }

    public static void main(String[] args) {
        MyProgram program = new MyProgram();
        program.run();
    }
}