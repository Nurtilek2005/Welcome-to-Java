package homework_2.task_5.calculator;

import homework_2.task_5.calculator.operation.*;

import java.util.HashMap;
import java.util.Objects;

public class Calculator {
    HashMap<String, IOperation> operations = new HashMap<>();

    public Calculator() {
        operations.put("+", new PlusOperation());
        operations.put("-", new MinusOperation());
        operations.put("/", new DivideOperation());
        operations.put("*", new MultipleOperation());
    }

    public void execute(String numbers) {
        String last = "";
        String[] regex = numbers.split(" ");
        for (int i = 0; i < regex.length; i++) {
            String number = regex[i].strip();
            if (Objects.equals(number, "")) continue;
            if (operations.containsKey(number)) {
                System.out.println(last + " " + number + " " + regex[i]);
                continue;
            }
            last = number;
        }
        IOperation operation = operations.get("+");
    }
}