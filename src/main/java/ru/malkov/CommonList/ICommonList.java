package ru.malkov.CommonList;

import java.util.List;

public interface ICommonList<T> {
    List<T> getCommonElements(List<T> list1, List<T> list2);
}
