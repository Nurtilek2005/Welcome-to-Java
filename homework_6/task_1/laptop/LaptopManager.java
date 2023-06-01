package homework_6.task_1.laptop;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class LaptopManager {
    private final Set<Laptop> laptopList = new LinkedHashSet<>();

    public Set<Laptop> getLaptopsByBrand(String brand) {
        Set<Laptop> filterLaptops = new LinkedHashSet<>();
        for (Laptop laptop: this.laptopList) {
            if (!Objects.equals(laptop.getBrand().toLowerCase(), brand.toLowerCase())) continue;
            filterLaptops.add(laptop);
        }
        return filterLaptops;
    }

    public Set<Laptop> getLaptopsByModel(String model) {
        Set<Laptop> filterLaptops = new LinkedHashSet<>();
        for (Laptop laptop: this.laptopList) {
            if (!Objects.equals(laptop.getModel().toLowerCase(), model.toLowerCase())) continue;
            filterLaptops.add(laptop);
        }
        return filterLaptops;
    }

    public Set<Laptop> getLaptopsBySerial(String serial) {
        Set<Laptop> filterLaptops = new LinkedHashSet<>();
        for (Laptop laptop: this.laptopList) {
            if (!Objects.equals(laptop.getSerial().toLowerCase(), serial.toLowerCase())) continue;
            filterLaptops.add(laptop);
        }
        return filterLaptops;
    }

    public void addLaptop(Laptop laptop) {
        this.laptopList.add(laptop);
    }

    public Set<Laptop> getLaptopList() {
        return this.laptopList;
    }
}
