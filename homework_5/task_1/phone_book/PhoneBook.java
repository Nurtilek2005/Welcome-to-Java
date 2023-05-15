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
    private final String fieldnames = "Имя,Фамилия,Отчество,Номера телефона";

    public PhoneBook() {
        FileWriter writer;
        this.dataPath = Path.of(".");
        this.dataBase = new File("data.csv");
        try {
            this.dataBase.createNewFile();
            if (!(this.isBaseEmpty())) return;
            writer = new FileWriter(this.dataBase);
            writer.write(this.fieldnames + "\n");
            writer.flush();
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        if (Files.isDirectory(this.dataBase.toPath())) {
            System.out.println("Вы специально создали папку вместо файла?");
            System.exit(1);
        }
    }

    public String[] getAllData() {
        FileReader reader;
        try {
            reader = new FileReader(this.dataBase);
            StringBuilder fileData = new StringBuilder();
            char next = (char) reader.read();
            while (next != (char) -1) {
                fileData.append(next);
                next = (char) reader.read();
            }
            reader.close();
            return fileData.toString().split("\n");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public boolean isBaseEmpty(){
        String[] data = this.getAllData();
        return data.length <= 1;
    }
}