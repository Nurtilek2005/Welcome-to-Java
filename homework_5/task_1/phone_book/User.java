package homework_5.task_1.phone_book;

public class User {
    private final int id;
    private String firstName;
    private String lastName;
    private String surname;
    private static int idCounter = 0;

    public User(String firstName, String lastName, String surname) {
        this.id = getNextId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.surname = surname;
    }

    private static synchronized int getNextId() {
        return ++idCounter;
    }

    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFullName() {
        StringBuilder result = new StringBuilder();
        result.append(this.getFirstName()).append(" ");
        result.append(this.getLastName()).append(" ");
        result.append(this.getSurname());
        return result.toString();
    }
}