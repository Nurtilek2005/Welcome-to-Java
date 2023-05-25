package homework_6.task_1.laptop.display;

import homework_6.task_1.laptop.Component;

public class Display extends Component {
    private double dimension;

    public Display(String brand, String model, String serial, double dimension) {
        super(brand, model, serial);
        this.dimension = dimension;
    }

    public double getDimension() {
        return this.dimension;
    }
}