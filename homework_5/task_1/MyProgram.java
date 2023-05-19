/*
Задача №1
========================================================
Реализуйте структуру телефонной книги с помощью HashMap,
учитывая, что 1 человек может иметь несколько телефонов.
Нужны методы добавления новой записи в книгу и метод
поиска записей в телефонной книге
========================================================
*/

package homework_5.task_1;

import homework_5.task_1.phone_book.Phone;
import homework_5.task_1.phone_book.PhoneBook;
import homework_5.task_1.phone_book.User;

public class MyProgram {
    public void run() {
        PhoneBook phoneBook = new PhoneBook();
        User user1 = new User("Андрей", "Андреев", "Андреевич");
        user1.addNumber(new Phone("+9148931237378"));
        user1.addNumber(new Phone("+1764328746723"));
        phoneBook.addUser(user1);
        User fUser = phoneBook.getUser("Андрей", "Андреев", "Андреевич");
        fUser.addNumber(new Phone("+5387487348"));
        phoneBook.saveUser(fUser);
    }

    public static void main(String[] args) {
        MyProgram program = new MyProgram();
        program.run();
    }
}