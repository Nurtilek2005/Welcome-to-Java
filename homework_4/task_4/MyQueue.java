package homework_4.task_4;

import java.util.ArrayList;

public class MyQueue<T> {
    ArrayList<T> queue = new ArrayList<>();

    public T first() {
        return queue.get(queue.size() - 1);
    }

    public void enqueue(T item) {
        ArrayList<T> newQueue = new ArrayList<>();
        newQueue.add(item);
        newQueue.addAll(queue);
        queue = newQueue;
    }

    public T dequeue() {
        ArrayList<T> newQueue = new ArrayList<>();
        for (int i = 1; i < queue.size(); i++) {
            newQueue.add(queue.get(queue.size() - i - 1));
        }
        T first = this.first();
        queue = newQueue;
        return first;
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}