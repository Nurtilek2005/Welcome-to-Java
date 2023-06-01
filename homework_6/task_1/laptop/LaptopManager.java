package homework_6.task_1.laptop;

import homework_6.task_1.laptop.cpu.CPU;
import homework_6.task_1.laptop.display.Display;
import homework_6.task_1.laptop.memory.Memory;
import homework_6.task_1.laptop.ram.RAM;

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

    public Set<Laptop> getLaptopsByCoresCount(int coresCount) {
        Set<Laptop> filterLaptops = new LinkedHashSet<>();
        for (Laptop laptop: this.laptopList) {
            CPU cpu = laptop.getCPU();
            if (coresCount == cpu.getCores()) {
                filterLaptops.add(laptop);
            }
        }
        return filterLaptops;
    }

    public Set<Laptop> getLaptopsByThreadsCount(int threadsCount) {
        Set<Laptop> filterLaptops = new LinkedHashSet<>();
        for (Laptop laptop: this.laptopList) {
            CPU cpu = laptop.getCPU();
            if (threadsCount == cpu.getThreads()) {
                filterLaptops.add(laptop);
            }
        }
        return filterLaptops;
    }

    public Set<Laptop> getLaptopsByRamSize(int ramSize) {
        Set<Laptop> filterLaptops = new LinkedHashSet<>();
        for (Laptop laptop: this.laptopList) {
            int laptopRam = 0;
            for (RAM ram: laptop.getRAMs().values()) {
                laptopRam += ram.getCapacity();
            }
            if (ramSize == laptopRam) {
                filterLaptops.add(laptop);
            }
        }
        return filterLaptops;
    }

    public Set<Laptop> getLaptopsByMemorySize(int memorySize) {
        Set<Laptop> filterLaptops = new LinkedHashSet<>();
        for (Laptop laptop: this.laptopList) {
            int laptopRam = 0;
            for (Memory memory: laptop.getMemories().values()) {
                laptopRam += memory.getCapacity();
            }
            if (memorySize == laptopRam) {
                filterLaptops.add(laptop);
            }
        }
        return filterLaptops;
    }

    public Set<Laptop> getLaptopsByDimension(double dimension) {
        Set<Laptop> filterLaptops = new LinkedHashSet<>();
        for (Laptop laptop: this.laptopList) {
            Display display = laptop.getDisplay();
            if (dimension == display.getDimension()) {
                filterLaptops.add(laptop);
            }
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
