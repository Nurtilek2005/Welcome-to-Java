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
import homework_6.task_1.laptop.LaptopManager;
import homework_6.task_1.laptop.cpu.CPU;
import homework_6.task_1.laptop.display.Display;
import homework_6.task_1.laptop.gpu.GPU;
import homework_6.task_1.laptop.memory.HDD;
import homework_6.task_1.laptop.memory.SSD;
import homework_6.task_1.laptop.ram.RAM;

public class MyProgram {
    public void run() {
        Laptop laptop1 = new Laptop("Asus", "ROG Flow", "X16", "Dark Grey");
        laptop1.setCPU(new CPU("AMD", "Ryzen 9", "7940HS", 8, 16, 4.0, 5.2));
        laptop1.setGPU(new GPU("NVIDIA", "GeForce", "RTX 4080"));
        laptop1.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 8));
        laptop1.setRAM(1, new RAM("Kingston", "HyperX", "Fury", 8));
        laptop1.setDisplay(new Display("Asus", "ROG Flow", "X16", 16));
        laptop1.setMemory(0, new SSD("Samsung", "NVMe", "980", 1000));

        Laptop laptop2 = new Laptop("Asus", "Vivobook S14", "S433FL", "Resolute Red");
        laptop2.setCPU(new CPU("Intel", "Core", "i7-10510U", 4, 8, 1.8, 4.9));
        laptop2.setGPU(new GPU("NVIDIA", "GeForce", "MX250"));
        laptop2.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 4));
        laptop2.setRAM(1, new RAM("Kingston", "HyperX", "Fury", 4));
        laptop2.setDisplay(new Display("Asus", "Vivobook S14", "S433FL", 14));
        laptop2.setMemory(0, new SSD("Samsung", "NVMe", "980", 1000));

        Laptop laptop3 = new Laptop("HP", "ENVY", "X360", "Dark Grey");
        laptop3.setCPU(new CPU("AMD", "Ryzen", "7-5825U", 8, 16, 2.3, 4.2));
        laptop3.setGPU(new GPU("AMD", "RADEON", "GRAPHICS"));
        laptop3.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 6));
        laptop3.setRAM(1, new RAM("Kingston", "HyperX", "Fury", 6));
        laptop3.setDisplay(new Display("HP", "ENVY", "X360", 15.6));
        laptop3.setMemory(0, new SSD("Samsung", "NVMe", "980", 1000));

        Laptop laptop4 = new Laptop("Acer", "Nitro 5", "AN515-55-59KU", "Dark Grey");
        laptop4.setCPU(new CPU("Intel", "Core", "i5-10300H", 4, 8, 2.5, 4.5));
        laptop4.setGPU(new GPU("NVIDIA", "GeForce", "GTX 1660Ti"));
        laptop4.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 8));
        laptop4.setRAM(1, new RAM("Kingston", "HyperX", "Fury", 8));
        laptop4.setDisplay(new Display("Acer", "Nitro 5", "AN515-55-59KU", 15.6));
        laptop4.setMemory(0, new SSD("Samsung", "NVMe", "980", 1000));

        Laptop laptop5 = new Laptop("Lenovo", "Legion 5 Pro", "16ARH7H", "Silver");
        laptop5.setCPU(new CPU("AMD", "Ryzen", "7 6800H", 8, 16, 3.2, 4.7));
        laptop5.setGPU(new GPU("NVIDIA", "GeForce", "RTX 3070"));
        laptop5.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 8));
        laptop5.setRAM(1, new RAM("Kingston", "HyperX", "Fury", 8));
        laptop5.setDisplay(new Display("Lenovo", "Legion 5 Pro", "16ARH7H", 16));
        laptop5.setMemory(0, new SSD("Samsung", "NVMe", "980", 1000));

        Laptop laptop6 = new Laptop("Lenovo", "IdeaPad 3", "15ADA05", "Dark Grey");
        laptop6.setCPU(new CPU("AMD", "Ryzen", "3 3250U", 2, 4, 2.6, 3.5));
        laptop6.setGPU(new GPU("AMD", "RADEON", "GRAPHICS"));
        laptop6.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 4));
        laptop6.setDisplay(new Display("Lenovo", "IdeaPad 3", "15ADA05", 15.6));
        laptop6.setMemory(0, new HDD("Seagate", "BarraCuda", "ST500LM030", 500));

        Laptop laptop7 = new Laptop("Acer", "Aspire 1", "A115-32-P859", "Silver");
        laptop7.setCPU(new CPU("Intel", "Pentium Silver", "N6000", 4, 4, 1.1, 3.3));
        laptop7.setGPU(new GPU("Intel", "UHD Graphics", "32 EUs"));
        laptop7.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 4));
        laptop7.setDisplay(new Display("Acer", "Aspire 1", "A115-32-P859", 15.6));
        laptop7.setMemory(0, new HDD("Seagate", "BarraCuda", "ST500LM030", 500));

        Laptop laptop8 = new Laptop("Acer", "Extensa 15", "EX215-31-C6FV", "Black");
        laptop8.setCPU(new CPU("Intel", "Celeron", "N4020", 2, 2, 1.1, 2.8));
        laptop8.setGPU(new GPU("Intel", "UHD Graphics", "600"));
        laptop8.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 4));
        laptop8.setDisplay(new Display("Acer", "Extensa 15", "EX215-31-C6FV", 15.6));
        laptop8.setMemory(0, new HDD("Seagate", "BarraCuda", "ST500LM030", 500));

        Laptop laptop9 = new Laptop("ASUS", "Laptop", "E410KA-EK125W", "Resolute Red");
        laptop9.setCPU(new CPU("Intel", "Celeron", "N4500", 2, 2, 1.1, 2.8));
        laptop9.setGPU(new GPU("Intel", "UHD Graphics", "32 EUs"));
        laptop9.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 4));
        laptop9.setDisplay(new Display("ASUS", "Laptop", "E410KA-EK125W", 14));
        laptop9.setMemory(0, new HDD("Seagate", "BarraCuda", "ST500LM030", 500));

        Laptop laptop10 = new Laptop("HUAWEI", "MateBook D 15", "BOD-WDI9", "Space Gray");
        laptop10.setCPU(new CPU("Intel", "Core", "i3-1115G4", 2, 2, 3, 4.1));
        laptop10.setGPU(new GPU("Intel", "UHD Graphics", "620"));
        laptop10.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 4));
        laptop10.setRAM(1, new RAM("Kingston", "HyperX", "Fury", 4));
        laptop10.setDisplay(new Display("HUAWEI", "MateBook D 15", "BOD-WDI9", 15.6));
        laptop10.setMemory(0, new SSD("Samsung", "NVMe", "980", 512));

        Laptop laptop11 = new Laptop("MSI", "Modern 14", "C12M-233XRU", "White");
        laptop11.setCPU(new CPU("Intel", "Core", "i3-1215U", 6, 8, 1.2, 4.4));
        laptop11.setGPU(new GPU("AMD", "RADEON", "GRAPHICS"));
        laptop11.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 4));
        laptop11.setRAM(1, new RAM("Kingston", "HyperX", "Fury", 4));
        laptop11.setDisplay(new Display("MSI", "Modern 14", "C12M-233XRU", 14));
        laptop11.setMemory(0, new SSD("Samsung", "NVMe", "980", 1000));

        Laptop laptop12 = new Laptop("Asus", "Vivobook Pro X16 OLED", "K6604JI", "Cool Silver");
        laptop12.setCPU(new CPU("Intel", "Core", "i9-13980HX", 24, 32, 2.2, 5.5));
        laptop12.setGPU(new GPU("NVIDIA", "GeForce", "RTX 4070"));
        laptop12.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 8));
        laptop12.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 8));
        laptop12.setDisplay(new Display("Asus", "Vivobook Pro X16 OLED", "K6604JI", 16));
        laptop12.setMemory(0, new SSD("Samsung", "NVMe", "980", 1000));

        Laptop laptop13 = new Laptop("Asus", "Zenbook 14 Flip OLED", "UP3404VA", "Foggy Silver");
        laptop13.setCPU(new CPU("Intel", "Core", "i7-1360P", 12, 16, 2.2, 5.0));
        laptop13.setGPU(new GPU("Intel", "Iris Xe", "GRAPHICS"));
        laptop13.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 8));
        laptop13.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 8));
        laptop13.setDisplay(new Display("Asus", "Zenbook 14 Flip OLED", "UP3404VA", 14));
        laptop13.setMemory(0, new SSD("Samsung", "NVMe", "980", 1000));

        Laptop laptop14 = new Laptop("Asus", "Zenbook 14 Flip OLED", "UP3404VA", "Ponder Blue");
        laptop14.setCPU(new CPU("Intel", "Core", "i5-1340P", 12, 16, 1.9, 4.6));
        laptop14.setGPU(new GPU("Intel", "Iris Xe", "GRAPHICS"));
        laptop14.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 8));
        laptop14.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 8));
        laptop14.setDisplay(new Display("Asus", "Zenbook 14 Flip OLED", "UP3404VA", 14));
        laptop14.setMemory(0, new SSD("Samsung", "NVMe", "980", 1000));

        Laptop laptop15 = new Laptop("Acer", "Aspire 1", "A115-32-P859", "Silver");
        laptop15.setCPU(new CPU("Intel", "Pentium Silver", "N6000", 4, 4, 1.1, 3.3));
        laptop15.setGPU(new GPU("AMD", "RADEON", "GRAPHICS"));
        laptop15.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 4));
        laptop15.setDisplay(new Display("Acer", "Aspire 1", "A115-32-P859", 15));
        laptop15.setMemory(0, new HDD("Seagate", "BarraCuda", "ST500LM030", 500));

        Laptop laptop16 = new Laptop("Acer", "Aspire 1", "A115-32-P859", "Silver");
        laptop16.setCPU(new CPU("Intel", "Pentium Silver", "N6000", 4, 4, 1.1, 3.3));
        laptop16.setGPU(new GPU("AMD", "RADEON", "GRAPHICS"));
        laptop16.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 4));
        laptop16.setDisplay(new Display("Acer", "Aspire 1", "A115-32-P859", 15));
        laptop16.setMemory(0, new HDD("Seagate", "BarraCuda", "ST500LM030", 500));

        Laptop laptop17 = new Laptop("Acer", "Aspire 1", "A115-32-P859", "Silver");
        laptop17.setCPU(new CPU("Intel", "Pentium Silver", "N6000", 4, 4, 1.1, 3.3));
        laptop17.setGPU(new GPU("AMD", "RADEON", "GRAPHICS"));
        laptop17.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 4));
        laptop17.setDisplay(new Display("Acer", "Aspire 1", "A115-32-P859", 15));
        laptop17.setMemory(0, new HDD("Seagate", "BarraCuda", "ST500LM030", 500));

        Laptop laptop18 = new Laptop("Acer", "Aspire 1", "A115-32-P859", "Silver");
        laptop18.setCPU(new CPU("Intel", "Pentium Silver", "N6000", 4, 4, 1.1, 3.3));
        laptop18.setGPU(new GPU("AMD", "RADEON", "GRAPHICS"));
        laptop18.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 4));
        laptop18.setDisplay(new Display("Acer", "Aspire 1", "A115-32-P859", 15));
        laptop18.setMemory(0, new HDD("Seagate", "BarraCuda", "ST500LM030", 500));

        Laptop laptop19 = new Laptop("Acer", "Aspire 1", "A115-32-P859", "Silver");
        laptop19.setCPU(new CPU("Intel", "Pentium Silver", "N6000", 4, 4, 1.1, 3.3));
        laptop19.setGPU(new GPU("AMD", "RADEON", "GRAPHICS"));
        laptop19.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 4));
        laptop19.setDisplay(new Display("Acer", "Aspire 1", "A115-32-P859", 15));
        laptop19.setMemory(0, new HDD("Seagate", "BarraCuda", "ST500LM030", 500));

        Laptop laptop20 = new Laptop("Acer", "Aspire 1", "A115-32-P859", "Silver");
        laptop20.setCPU(new CPU("Intel", "Pentium Silver", "N6000", 4, 4, 1.1, 3.3));
        laptop20.setGPU(new GPU("AMD", "RADEON", "GRAPHICS"));
        laptop20.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 4));
        laptop20.setDisplay(new Display("Acer", "Aspire 1", "A115-32-P859", 15));
        laptop20.setMemory(0, new HDD("Seagate", "BarraCuda", "ST500LM030", 500));

        Laptop laptop21 = new Laptop("Acer", "Aspire 1", "A115-32-P859", "Silver");
        laptop21.setCPU(new CPU("Intel", "Pentium Silver", "N6000", 4, 4, 1.1, 3.3));
        laptop21.setGPU(new GPU("AMD", "RADEON", "GRAPHICS"));
        laptop21.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 4));
        laptop21.setDisplay(new Display("Acer", "Aspire 1", "A115-32-P859", 15));
        laptop21.setMemory(0, new HDD("Seagate", "BarraCuda", "ST500LM030", 500));

        Laptop laptop22 = new Laptop("Acer", "Aspire 1", "A115-32-P859", "Silver");
        laptop22.setCPU(new CPU("Intel", "Pentium Silver", "N6000", 4, 4, 1.1, 3.3));
        laptop22.setGPU(new GPU("AMD", "RADEON", "GRAPHICS"));
        laptop22.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 4));
        laptop22.setDisplay(new Display("Acer", "Aspire 1", "A115-32-P859", 15));
        laptop22.setMemory(0, new HDD("Seagate", "BarraCuda", "ST500LM030", 500));

        Laptop laptop23 = new Laptop("Acer", "Aspire 1", "A115-32-P859", "Silver");
        laptop23.setCPU(new CPU("Intel", "Pentium Silver", "N6000", 4, 4, 1.1, 3.3));
        laptop23.setGPU(new GPU("AMD", "RADEON", "GRAPHICS"));
        laptop23.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 4));
        laptop23.setDisplay(new Display("Acer", "Aspire 1", "A115-32-P859", 15));
        laptop23.setMemory(0, new HDD("Seagate", "BarraCuda", "ST500LM030", 500));

        Laptop laptop24 = new Laptop("Acer", "Aspire 1", "A115-32-P859", "Silver");
        laptop24.setCPU(new CPU("Intel", "Pentium Silver", "N6000", 4, 4, 1.1, 3.3));
        laptop24.setGPU(new GPU("AMD", "RADEON", "GRAPHICS"));
        laptop24.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 4));
        laptop24.setDisplay(new Display("Acer", "Aspire 1", "A115-32-P859", 15));
        laptop24.setMemory(0, new HDD("Seagate", "BarraCuda", "ST500LM030", 500));

        Laptop laptop25 = new Laptop("Acer", "Aspire 1", "A115-32-P859", "Silver");
        laptop25.setCPU(new CPU("Intel", "Pentium Silver", "N6000", 4, 4, 1.1, 3.3));
        laptop25.setGPU(new GPU("AMD", "RADEON", "GRAPHICS"));
        laptop25.setRAM(0, new RAM("Kingston", "HyperX", "Fury", 4));
        laptop25.setDisplay(new Display("Acer", "Aspire 1", "A115-32-P859", 15));
        laptop25.setMemory(0, new HDD("Seagate", "BarraCuda", "ST500LM030", 500));

        LaptopManager manager = new LaptopManager();
        manager.addLaptop(laptop1);
        manager.addLaptop(laptop2);
        manager.addLaptop(laptop3);
        manager.addLaptop(laptop4);
        manager.addLaptop(laptop5);
        manager.addLaptop(laptop6);
        manager.addLaptop(laptop7);
        manager.addLaptop(laptop8);
        manager.addLaptop(laptop9);
        manager.addLaptop(laptop10);
        manager.addLaptop(laptop11);
        manager.addLaptop(laptop12);
        manager.addLaptop(laptop13);
        manager.addLaptop(laptop14);
        manager.addLaptop(laptop15);
        manager.addLaptop(laptop16);
        manager.addLaptop(laptop17);
        manager.addLaptop(laptop18);
        manager.addLaptop(laptop19);
        manager.addLaptop(laptop20);
        manager.addLaptop(laptop21);
        manager.addLaptop(laptop22);
        manager.addLaptop(laptop23);
        manager.addLaptop(laptop24);
        manager.addLaptop(laptop25);

        System.out.println(manager.getLaptopsByModel("ENVY"));
    }

    public static void main(String[] args) {
        MyProgram program = new MyProgram();
        program.run();
    }
}