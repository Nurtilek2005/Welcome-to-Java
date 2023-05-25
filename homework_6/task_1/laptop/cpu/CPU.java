package homework_6.task_1.laptop.cpu;

import homework_6.task_1.laptop.Component;

public class CPU extends Component {
    private final int cores;
    private final int threads;
    private final double lowerFrequency;
    private final double upperFrequency;

    public CPU(String brand, String model, String serial, int cores, int threads, double lowerFrequency, double upperFrequency) {
        super(brand, model, serial);
        this.cores = cores;
        this.threads = threads;
        this.lowerFrequency = lowerFrequency;
        this.upperFrequency = upperFrequency;
    }

    public int getCores() {
        return this.cores;
    }

    public int getThreads() {
        return this.threads;
    }

    public double getLowerFrequency() {
        return this.lowerFrequency;
    }

    public double getUpperFrequency() {
        return this.upperFrequency;
    }
}