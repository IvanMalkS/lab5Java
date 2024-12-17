package ru.malkov.CommonList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonList<T> implements ICommonList<T> {
    public List<T> getCommonElements(List<T> list1, List<T> list2) {
        Set<T> set1 = new HashSet<>(list1);
        Set<T> set2 = new HashSet<>(list2);

        set1.retainAll(set2);

        return new ArrayList<>(set1);
    }

    @Override
    public String toString() {
        return "CommonList Class";
    }
}
