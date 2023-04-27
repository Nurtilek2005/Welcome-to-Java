package homework_2.task_5.calculator.operation;

public class PlusOperation implements IOperation {
    @Override
    public double execute(double... numbers) {
        double result = 0;
        for (double number: numbers) {
            result += number;
        }
        return result;
    }
}