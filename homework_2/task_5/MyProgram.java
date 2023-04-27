/* Задача №5
 * ==========================================================================================================
 * К калькулятору из предыдущего дз добавить логирование.
 * ==========================================================================================================
 */

package homework_2.task_5;

import homework_2.task_5.calculator.Calculator;

import java.util.Scanner;

public class MyProgram {
    public enum Operation {
        PLUS,
        MINUS,
        MULTIPLE,
        DIVIDE
    }

    public int getInt(String message) {
        Scanner iScanner = new Scanner(System.in);
        while (true) {
            if (message != null) System.out.println(message);
            String intoLine = iScanner.nextLine();
            try {
                return Integer.parseInt(intoLine);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect number!");
            }
        }
    }

    public Object getOperation() {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Select operation");
        System.out.println("1 - PLUS");
        System.out.println("2 - MINUS");
        System.out.println("3 - MULTIPLE");
        System.out.println("4 - DIVIDE");
        System.out.print(">>> ");
        String intoLine = iScanner.nextLine();
        switch (intoLine) {
            case "1":
            case "plus":
                return Operation.PLUS;
            case "2":
            case "minus":
                return Operation.MINUS;
            case "3":
            case "multiple":
                return Operation.MULTIPLE;
            case "4":
            case "divide":
                return Operation.DIVIDE;
            default:
                System.out.println("Invalid operation");
                return null;
        }
    }

    public Object execOperation(int numberA, int numberB, Operation op) {
        if (op.equals(Operation.PLUS)) {
            return numberA + numberB;
        } else if (op.equals(Operation.MINUS)) {
            return numberA - numberB;
        } else if (op.equals(Operation.MULTIPLE)) {
            return numberA * numberB;
        } else if (op.equals(Operation.DIVIDE)) {
            return numberA / numberB;
        } else {
            return null;
        }
    }

    public void run() {
        int number_1 = getInt("Enter number 1");
        int number_2 = getInt("Enter number 2");
        while (true) {
            Object operation = getOperation();
            if (!(operation instanceof Operation)) {
                continue;
            }
            Object result = execOperation(number_1, number_2, (Operation) operation);
            System.out.println(result);
            break;
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.execute(" 1    +  2  ");
    }
}