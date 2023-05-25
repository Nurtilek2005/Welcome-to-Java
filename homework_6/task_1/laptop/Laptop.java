package homework_6.task_1.laptop;

import homework_6.task_1.laptop.cpu.CPU;
import homework_6.task_1.laptop.display.Display;
import homework_6.task_1.laptop.gpu.GPU;
import homework_6.task_1.laptop.memory.Memory;
import homework_6.task_1.laptop.ram.RAM;

import java.util.HashMap;
import java.util.Map;

public class Laptop {
    private final String brand;
    private final String model;
    private final String serial;
    private final String color;

    private CPU cpu;
    private GPU gpu;
    private Display display;
    private final Map<Integer, RAM> rams = new HashMap<>();
    private final Map<Integer, Memory> memories = new HashMap<>();

    public Laptop(String brand, String model, String serial, String color) {
        this.brand = brand;
        this.model = model;
        this.serial = serial;
        this.color = color;
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

    public String getColor() {
        return this.color;
    }

    public void setCPU(CPU cpu) {
        this.cpu = cpu;
    }

    public CPU getCPU() {
        return this.cpu;
    }

    public void setGPU(GPU gpu) {
        this.gpu = gpu;
    }

    public GPU getGPU() {
        return this.gpu;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Display getDisplay() {
        return this.display;
    }

    public Map<Integer, RAM> getRAMs() {
        return this.rams;
    }

    public boolean isRAMExists(int slot) {
        return this.getRAMs().containsKey(slot);
    }

    public RAM getRAM(int slot) {
        if (!this.isRAMExists(slot)) return null;
        return this.getRAMs().get(slot);
    }

    public void setRAM(int slot, RAM ram) {
        this.getRAMs().put(slot, ram);
    }

    public void unsetRAM(int slot) {
        this.getRAMs().remove(slot);
    }

    public Map<Integer, Memory> getMemories() {
        return this.memories;
    }

    public boolean isMemoryExists(int id) {
        return this.getMemories().containsKey(id);
    }

    public Memory getMemory(int id) {
        if (!this.isMemoryExists(id)) return null;
        return this.getMemories().get(id);
    }

    public void setMemory(int id, Memory memory) {
        this.getMemories().put(id, memory);
    }

    public void unsetMemory(int id) {
        this.getMemories().remove(id);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.getBrand()).append(" ");
        result.append(this.getModel()).append(" ");
        result.append(this.getSerial()).append(" ");
        result.append(this.getColor());
        return result.toString();
    }
}