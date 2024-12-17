package ru.malkov.QueueBuilder;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class QueueBuilder<T> implements IQueueBuilder<T> {
    @Override
    public Deque<T> buildQueue(List<T> list) {
        Deque<T> queue = new ArrayDeque<>();

        for (T element : list) {
            queue.addLast(element);
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            queue.addLast(list.get(i));
        }

        return queue;
    }

    @Override
    public String toString() {
        return "Queue Builder";
    }
}
