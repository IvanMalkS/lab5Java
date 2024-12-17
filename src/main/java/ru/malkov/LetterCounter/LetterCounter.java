package ru.malkov.LetterCounter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class LetterCounter implements ILetterCounter {
    public int countUniqueLetters(String filePath) throws IOException {
        Set<Character> uniqueLetters = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (Character.isLetter(c)) {
                        uniqueLetters.add(Character.toLowerCase(c));
                    }
                }
            }
        }
        return uniqueLetters.size();
    }

    @Override
    public String toString() {
        return "LetterCounter";
    }
}
