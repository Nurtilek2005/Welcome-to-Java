package homework_5.task_1.phone_book;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PhoneBook {
    private final Path dataPath;
    private final File dataBase;

    public PhoneBook() {
        FileWriter writer;
        FileReader reader;
        this.dataPath = Path.of(".");
        this.dataBase = new File("data.csv");
        try {
            this.dataBase.createNewFile();
            reader = new FileReader(this.dataBase);
            writer = new FileWriter(this.dataBase);
            writer.write("Имя,Фамилия,Отчество,Номера телефона\n");
            writer.flush();
            writer.close();
            char [] a = new char[36];
            reader.read(a);
            for(char c : a)
                System.out.print(c);
            reader.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        if (Files.isDirectory(this.dataBase.toPath())) {
            System.out.println("Вы специально создали папку вместо файла?");
            System.exit(1);
        }
    }
}