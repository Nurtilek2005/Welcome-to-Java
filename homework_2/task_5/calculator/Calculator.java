package homework_2.task_5.calculator;

import homework_2.task_5.calculator.operation.*;

import java.util.HashMap;
import java.util.logging.Logger;

public class Calculator {
    HashMap<String, IOperation> operations = new HashMap<>();
    Logger logger = Logger.getLogger(this.getClass().getName());

    public Calculator() {
        logger.info("Loading operations...");
        operations.put("+", new PlusOperation());
        operations.put("-", new MinusOperation());
        operations.put("/", new DivideOperation());
        operations.put("*", new MultipleOperation());
        logger.info("Operations loaded!");
    }

    public double execute(String numbers) {
        String last = "";
        logger.info("Got: " + numbers);
        logger.info("Removing trailing...");
        while (numbers.contains("  ")) {
            numbers = numbers.replace("  ", " ");
            numbers = numbers.stripIndent();
        }
        logger.info("Removing trailing success!");
        logger.info("Solving...");
        String[] parts = numbers.split(" ");
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i].strip();
            if (operations.containsKey(part)) {
                IOperation operation = operations.get(part);
                String next = parts[++i].strip();
                if (operations.containsKey(next)) {
                    logger.severe("Found operation while solving each!");
                    return 0;
                }
                try {
                    double lastNum = Double.parseDouble(last);
                    double nextNum = Double.parseDouble(next);
                    double result = operation.execute(lastNum, nextNum);
                    last = String.valueOf(result);
                    continue;
                } catch (NumberFormatException e) {
                    logger.severe("Incorrect number format! M: " + e.getMessage());
                }
            }
            last = part;
        }
        logger.info("Success!");
        return Double.parseDouble(last);
    }
}