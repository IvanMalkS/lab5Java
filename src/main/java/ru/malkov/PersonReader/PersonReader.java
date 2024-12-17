package ru.malkov.PersonReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonReader implements IPersonReader {

    @Override
    public Map<Integer, List<String>> readAndProcessPersons(String filePath) {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return lines
                    .map(line -> line.split(":"))
                    .filter(parts -> parts.length == 2 && !parts[1].isEmpty())
                    .map(parts -> new Person(capitalize(parts[0].toLowerCase()), Integer.parseInt(parts[1])))
                    .collect(Collectors.groupingBy(
                            Person::getNumber,
                            Collectors.mapping(Person::getName, Collectors.toList())
                    ));
        } catch (IOException e) {
            e.printStackTrace();
            return Map.of();
        }
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    @Override
    public String toString() {
        return "PersonReader{}";
    }
}
