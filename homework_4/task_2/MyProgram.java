/*
Задача №2
====================================================================================
Реализуйте очередь с помощью LinkedList со следующими методами: enqueue() - помещает
элемент в конец очереди, dequeue() - возвращает первый элемент из очереди и удаляет
его, first() - возвращает первый элемент из очереди, не удаляя.
====================================================================================
*/

package homework_4.task_2;

public class MyProgram {
    public void run() {
        MyQueue<Object> queue = new MyQueue<>();
        queue.enqueue("Hello World!");
        System.out.println(queue.first());
        System.out.println(queue.dequeue());
    }

    public static void main(String[] args) {
        MyProgram program = new MyProgram();
        program.run();
    }
}