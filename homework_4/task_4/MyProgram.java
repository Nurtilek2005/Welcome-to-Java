/*
Задача №4
============================================================================
*реализовать вторую задачу через собственный класс используя в основе массив
============================================================================
*/

package homework_4.task_4;

public class MyProgram {
    public void run() {
        MyQueue<Object> queue = new MyQueue<>();
        queue.enqueue("Hello");
        queue.enqueue("World!");
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
    }

    public static void main(String[] args) {
        MyProgram program = new MyProgram();
        program.run();
    }
}