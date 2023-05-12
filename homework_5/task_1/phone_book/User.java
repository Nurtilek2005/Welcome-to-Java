package homework_5.task_1.phone_book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private final int id;
    private String firstName;
    private String lastName;
    private String surname;
    private final List<Phone> phoneNumbers;

    private static int idCounter = 0;

    public User(String firstName, String lastName, String surname) {
        this.id = getNextId();
        this.phoneNumbers = new ArrayList<>();
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

    public List<Phone> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public boolean addNumber(Phone phoneNumber) {
        if (this.phoneNumbers.contains(phoneNumber)) return false;
        this.phoneNumbers.add(phoneNumber);
        return true;
    }

    public Phone getPhoneNumber(String phoneNumber) {
        return this.getPhoneNumber(phoneNumber, false);
    }

    public Phone getPhoneNumber(String phoneNumber, boolean key) {
        for (Phone phone : this.phoneNumbers) {
            if (Objects.equals(phone.getPhoneNumber(), phoneNumber)) return phone;
        }
        return null;
    }

    /* В данном случаи так можно. Но если там будут параметры... */
    /* Как можно сделать без цикла?? */
    public boolean hasPhoneNumber(String phoneNumber) {
        return this.phoneNumbers.contains(new Phone(phoneNumber));
    }

    /* Не додумался, как реализовать setPhoneNumber из Phone */
    /* Можно через цикл for, но это потеря производительности */
    public boolean changePhoneNumber(Phone oldPhone, Phone newPhone) {
        if (!(this.hasPhoneNumber(oldPhone.getPhoneNumber()))) return false;
        this.removePhoneNumber(oldPhone.getPhoneNumber());
        this.addNumber(newPhone);
        return true;
    }

    /* Тут можно было по другому сделать?? */
    public boolean removePhoneNumber(String phoneNumber) {
        if (!(this.hasPhoneNumber(phoneNumber))) return false;
        Phone phone = this.getPhoneNumber(phoneNumber);
        this.phoneNumbers.remove(phone);
        return true;
    }

    public String getFullName() {
        StringBuilder result = new StringBuilder();
        result.append(this.getFirstName()).append(" ");
        result.append(this.getLastName()).append(" ");
        result.append(this.getSurname());
        return result.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User user) {
            boolean fname = Objects.equals(user.getFirstName(), this.getFirstName());
            boolean lname = Objects.equals(user.getLastName(), this.getLastName());
            boolean sname = Objects.equals(user.getSurname(), this.getSurname());
            return fname && lname && sname;
        }
        return false;
    }
}