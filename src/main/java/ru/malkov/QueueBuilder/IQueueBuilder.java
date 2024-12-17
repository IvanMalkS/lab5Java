package ru.malkov.QueueBuilder;

import java.util.Deque;
import java.util.List;

public interface IQueueBuilder<T> {
    Deque<T> buildQueue(List<T> list);
}
