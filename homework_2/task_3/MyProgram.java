/* Задача №3
 * ==========================================================================================================
 * Напишите программу, которая принимает с консоли число в формате byte и записывает его в файл ”result.txt”.
 * Требуется перехватить все возможные ошибки и вывести их в логгер.
 * После написания, попробуйте подать на вход числа 100 и 200 и проследите разницу в результате
 * ==========================================================================================================
 */

package homework_2.task_3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyProgram {
    protected Logger logger;

    public void run() {
        logger.log(Level.INFO, "Program is runned!");
        System.out.print("Введите байт число.\n>>> ");
        Scanner iScanner = new Scanner(System.in);
        byte number;
        try {
            number = iScanner.nextByte();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Ошибка при чтении числа: " + e.getMessage());
            return;
        }
        try (FileWriter writer = new FileWriter("result.txt")) {
            writer.write(Byte.toString(number));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка при записи в файл: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        MyProgram program = new MyProgram();
        program.logger = Logger.getLogger(MyProgram.class.getName());
        program.run();
    }
}