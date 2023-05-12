package homework_5.task_1.phone_book;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PhoneBook {
    private final Path dataPath;
    private final File dataBase;

    public PhoneBook() {
        this.dataPath = Path.of(".");
        this.dataBase = new File("data.json");
        try {
            this.dataBase.createNewFile();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        if (Files.isDirectory(this.dataBase.toPath())) {
            System.out.println("Вы специально создали папку вместо файла?");
            System.exit(1);
        }

    }
}