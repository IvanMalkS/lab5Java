package ru.malkov.PersonReader;

import java.util.List;
import java.util.Map;

public interface IPersonReader {
    Map<Integer, List<String>> readAndProcessPersons(String filePath);
}

