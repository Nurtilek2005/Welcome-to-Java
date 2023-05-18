package homework_5.task_1.phone_book;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    public String[][] getAllData() {
        String[][] data = new String[][]{};
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
            int index = 0;
            for (String line: fileData.toString().split("\n")) {
                data = Arrays.copyOf(data, data.length + 1);
                data[index++] = line.split(",");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return data;
    }

    public boolean isBaseEmpty(){
        String[][] data = this.getAllData();
        return data.length <= 1;
    }

    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();
        if (this.isBaseEmpty()) return userList;
        String[][] data = this.getAllData();
        for (int i = 1; i < data.length; i++) {
            String[] userData = data[i];
            String firstName = userData[0];
            String lastName = userData[1];
            String surname = userData[2];
            User user = new User(firstName, lastName, surname);
            String[] phoneNumbers = Arrays.copyOfRange(userData, 3, userData.length);
            for (String phoneNumber: phoneNumbers) {
                user.addNumber(new Phone(phoneNumber));
            }
            userList.add(user);
        }
        return userList;
    }
}