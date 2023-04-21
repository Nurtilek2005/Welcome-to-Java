package homework_1.task_4;

import java.util.Scanner;

public class MyProgram {
    public static int getInt(String message) {
        Scanner iScanner = new Scanner(System.in);
        while (true) {
            if (message != null) System.out.println(message);
            String intoLine = iScanner.nextLine();
            try {
                int number = Integer.parseInt(intoLine);
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect number!");
                continue;
            }
        }
    }

    public static void main(String[] args) {
        
    }
}