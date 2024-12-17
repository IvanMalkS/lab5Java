package ru.malkov.Cat;

public class MeowableCat {
    public static void makeAllMeow(Meowable... meowables) {
        for (Meowable meowable : meowables) {
            meowable.meow();
        }
    }

}
