package homework_2.task_5.calculator.operation;

public class PlusOperation implements IOperation {
    @Override
    public double execute(double... numbers) {
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result += numbers[i];
        }
        return result;
    }
}