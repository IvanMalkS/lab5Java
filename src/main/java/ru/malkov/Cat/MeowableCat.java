package ru.malkov.Cat;

public class MeowableCat {
    public static void makeAllMeow(Cat... meowables) {
        for (Cat meowable : meowables) {
            meowable.meow();
        }
    }

}
