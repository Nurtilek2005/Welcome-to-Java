package homework_6.task_1;

/*
Подумать над структурой класса Ноутбук для магазина техники - выделить
поля и методы. Реализовать в java. Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии)
фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно
хранить в Map. Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить
параметры фильтрации можно также в Map. Отфильтровать ноутбуки из первоначального
множества и вывести проходящие по условиям.
Работу сдать как обычно ссылкой на гит репозиторий
P.S. Частые ошибки смотри в конце семинара
*/

import homework_6.task_1.laptop.Laptop;
import homework_6.task_1.laptop.cpu.CPU;
import homework_6.task_1.laptop.display.Display;
import homework_6.task_1.laptop.gpu.GPU;
import homework_6.task_1.laptop.memory.Memory;
import homework_6.task_1.laptop.memory.SSD;
import homework_6.task_1.laptop.ram.RAM;

public class MyProgram {
    public static void main(String[] args) {
        Laptop laptop = new Laptop("ASTRO", "TOR", "Zeus Plaid S13", "Dark Grey");
        CPU cpu = new CPU("AMUDE", "Ryzen 7", "7500E", 8, 16, 2.3, 4.2);
        GPU gpu = new GPU("AMUDE", "Radik", "Vector 7");
        RAM ram1 = new RAM("Kingsman", "HydraZ", "Beast");
        RAM ram2 = new RAM("Kingsman", "HydraZ", "Beast");
        Memory memory1 = new SSD("Terabyte", "Saver", "SV256", 256);
        Memory memory2 = new SSD("East", "Deals", "HCB2T", 2048);
        Display display = new Display("ASTRO", "TOR", "ZPS13", 17.3);
        laptop.setCPU(cpu);
        laptop.setGPU(gpu);
        laptop.setRAM(0, ram1);
        laptop.setRAM(2, ram1);
        laptop.setDisplay(display);
        laptop.setMemory(0, memory1);
        laptop.setMemory(1, memory2);

        System.out.println(laptop);
    }
}