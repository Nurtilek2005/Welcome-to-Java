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

import homework_5.task_1.phone_book.User;

public class MyProgram {
    public void run() {
        User user1 = new User("Андрей", "Андреев", "Андреевич");
        User user2 = new User("Матвей", "Матвеев", "Матвеевич");
        System.out.println(user1.getId() + ": " + user1.getFullName());
        System.out.println(user2.getId() + ": " + user2.getFullName());
    }

    public static void main(String[] args) {
        MyProgram program = new MyProgram();
        program.run();
    }
}