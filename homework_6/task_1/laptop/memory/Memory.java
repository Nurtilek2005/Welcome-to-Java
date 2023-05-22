package homework_6.task_1.laptop.memory;

import homework_6.task_1.laptop.Component;

public abstract class Memory extends Component {
    private final int capacity;

    public Memory(String brand, String model, String serial, int capacity) {
        super(brand, model, serial);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }
}