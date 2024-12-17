package ru.malkov.Cat;

public class MeowableCat {
    public  void makeAllMeow(Meowable... meowables) {
        for (Meowable meowable : meowables) {
            meowable.meow();
        }
    }

}
