/* Задача №5
 * ==========================================================================================================
 * К калькулятору из предыдущего дз добавить логирование.
 * ==========================================================================================================
 */

package homework_2.task_5;

import homework_2.task_5.calculator.Calculator;

import java.util.Scanner;

public class MyProgram {
    public void run() {
        Calculator calculator = new Calculator();
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите математическое выражение");
        double result = calculator.execute(iScanner.nextLine());
        System.out.println("Результат данного выражения: " + result);
    }

    public static void main(String[] args) {
        MyProgram program = new MyProgram();
        program.run();
    }
}