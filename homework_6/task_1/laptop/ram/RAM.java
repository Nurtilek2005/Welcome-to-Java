package homework_6.task_1.laptop.ram;

import homework_6.task_1.laptop.Component;

public class RAM extends Component {
    private final int capacity;

    public RAM(String brand, String model, String serial, int capacity) {
        super(brand, model, serial);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }
}