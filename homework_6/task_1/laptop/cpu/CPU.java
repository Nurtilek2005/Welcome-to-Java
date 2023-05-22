package homework_6.task_1.laptop.cpu;

import homework_6.task_1.laptop.Component;

public class CPU extends Component {
    private final double lowerFrequency;
    private final double upperFrequency;

    public CPU(String brand, String model, String serial, double lowerFrequency, double upperFrequency) {
        super(brand, model, serial);
        this.lowerFrequency = lowerFrequency;
        this.upperFrequency = upperFrequency;
    }

    public double getLowerFrequency() {
        return this.lowerFrequency;
    }

    public double getUpperFrequency() {
        return this.upperFrequency;
    }
}