package homework_2.task_5.calculator;

import homework_2.task_5.calculator.operation.*;

import java.util.Arrays;
import java.util.HashMap;

public class Calculator {
    HashMap<String, IOperation> operations = new HashMap<>();

    public Calculator() {
        operations.put("+", new PlusOperation());
        operations.put("-", new MinusOperation());
        operations.put("/", new DivideOperation());
        operations.put("*", new MultipleOperation());
    }

    public double execute(String numbers) {
        String last = "";
        while (numbers.contains("  ")) {
            numbers = numbers.replace("  ", " ");
            numbers = numbers.stripIndent();
        }
        String[] parts = numbers.split(" ");
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i].strip();
            if (operations.containsKey(part)) {
                IOperation operation = operations.get(part);
                String next = parts[++i].strip();
                if (operations.containsKey(next)) {
                    throw new IllegalArgumentException();
                }
                try {
                    double lastNum = Double.parseDouble(last);
                    double nextNum = Double.parseDouble(next);
                    double result = operation.execute(lastNum, nextNum);
                    last = String.valueOf(result);
                    continue;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException();
                }
            }
            last = part;
        }
        return Double.parseDouble(last);
    }
}