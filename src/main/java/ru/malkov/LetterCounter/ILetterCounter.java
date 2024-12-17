package ru.malkov.LetterCounter;

import java.io.IOException;

public interface ILetterCounter {
    int countUniqueLetters(String filePath) throws IOException;
}
