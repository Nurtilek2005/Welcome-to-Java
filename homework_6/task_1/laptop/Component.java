package homework_6.task_1.laptop;

public abstract class Component {
    protected String brand;
    protected String model;
    protected String serial;

    public Component(String brand, String model, String serial) {
        this.brand = brand;
        this.model = model;
        this.serial = serial;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public String getSerial() {
        return this.serial;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.getBrand()).append(" ");
        result.append(this.getModel()).append(" ");
        result.append(this.getSerial());
        return result.toString();
    }
}