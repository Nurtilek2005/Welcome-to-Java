package homework_5.task_1.phone_book;

public class Phone {
    private final int id;
    private String phoneNumber;
    private static int idCounter = 0;

    public Phone(int phone_number) {
        this.id = getNextId();
    }

    private static synchronized int getNextId() {
        return ++idCounter;
    }

    public int getId() {
        return this.id;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}