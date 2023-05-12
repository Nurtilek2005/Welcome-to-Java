package homework_5.task_1.phone_book;

import java.util.Objects;

public class Phone {
    private String phoneNumber;

    public Phone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean equals(Object phoneNumber) {
        if (phoneNumber instanceof Phone phone) {
            return Objects.equals(this.getPhoneNumber(), phone.getPhoneNumber());
        }
        return false;
    }

    @Override
    public String toString() {
        return this.phoneNumber;
    }
}