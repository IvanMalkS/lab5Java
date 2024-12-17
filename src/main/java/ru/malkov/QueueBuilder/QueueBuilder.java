package ru.malkov.QueueBuilder;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class QueueBuilder {
    public Deque<Integer> buildQueue(List<Integer> list) {
        Deque<Integer> queue = new ArrayDeque<>();

        for (Integer element : list) {
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

