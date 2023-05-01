package homework_4.task_2;

import java.util.LinkedList;

public class MyQueue<T> {
    LinkedList<T> queue = new LinkedList<>();

    public T first() {
        return queue.getFirst();
    }

    public void enqueue(T item) {
        queue.addLast(item);
    }

    public T dequeue() {
        T item = this.first();
        queue.removeFirst();
        return item;
    }
}