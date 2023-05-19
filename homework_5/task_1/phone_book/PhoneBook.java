package homework_5.task_1.phone_book;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

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

    public void saveAllData(String[][] newData) {
        FileWriter writer;
        try {
            writer = new FileWriter(this.dataBase);
            for (String[] userData: newData) {
                writer.write(String.join(",", userData) + "\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
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

    public boolean userExists(String firstName, String lastName, String surname) {
        User user = this.getUser(firstName, lastName, surname);
        return user instanceof User;
    }

    public void saveUser(User user) {
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String surname = user.getSurname();
        String[][] data = getAllData();
        for (int i = 0; i < data.length; i++) {
            String[] userData = data[i];
            boolean fname = Objects.equals(userData[0], firstName);
            boolean lname = Objects.equals(userData[1], lastName);
            boolean sname = Objects.equals(userData[2], surname);
            if (fname && lname && sname) {
                List<Phone> phones = user.getPhoneNumbers();
                for (int p = 0; p < phones.size(); p++) {
                    if (userData.length - 3 < phones.size()) {
                        userData = Arrays.copyOf(userData, userData.length + 1);
                    }
                    userData[p + 3] = phones.get(p).toString();
                }
            }
            data[i] = userData;
            i++;
        }
        this.saveAllData(data);
    }

    public boolean addUser(User user) {
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String surname = user.getSurname();
        if (this.userExists(firstName, lastName, surname)) {
            return false;
        }
        String[][] data = getAllData();
        data = Arrays.copyOf(data, data.length + 1);
        StringBuilder userData = new StringBuilder();
        userData.append(firstName).append(",");
        userData.append(lastName).append(",");
        userData.append(surname).append(",");
        List<Phone> phones = user.getPhoneNumbers();
        String[] phoneNumbers = new String[phones.size()];
        for (int i = 0; i < phones.size(); i++) {
            phoneNumbers[i] = phones.get(i).toString();
        }
        userData.append(String.join(",", phoneNumbers));
        data[data.length] = userData.toString().split(",");
        this.saveAllData(data);
        return true;
    }

    public boolean deleteUser(String firstName, String lastName, String surname) {
        if (!this.userExists(firstName, lastName, surname)) {
            return false;
        }
        int index = 0;
        String[][] data = getAllData();
        String[][] newData = new String[data.length - 1][];
        for (int i = 0; i < data.length; i++) {
            String[] userData = data[i];
            boolean fname = Objects.equals(userData[0], firstName);
            boolean lname = Objects.equals(userData[1], lastName);
            boolean sname = Objects.equals(userData[2], surname);
            if (fname && lname && sname) {
                continue;
            }
            newData[index] = userData;
            index++;
        }
        this.saveAllData(newData);
        return true;
    }

    public User getUser(String firstName, String lastName, String surname) {
        if (this.isBaseEmpty()) return null;
        List<User> userList = getUsers();
        for (User user: userList) {
            boolean fname = Objects.equals(user.getFirstName(), firstName);
            boolean lname = Objects.equals(user.getLastName(), lastName);
            boolean sname = Objects.equals(user.getSurname(), surname);
            if (fname && lname && sname) return user;
        }
        return null;
    }
}