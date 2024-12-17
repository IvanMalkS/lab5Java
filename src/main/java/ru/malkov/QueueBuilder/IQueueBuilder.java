package ru.malkov.QueueBuilder;

import java.util.Deque;
import java.util.List;

public interface IQueueBuilder {
    Deque<Integer> buildQueue(List<Integer> list);
}
