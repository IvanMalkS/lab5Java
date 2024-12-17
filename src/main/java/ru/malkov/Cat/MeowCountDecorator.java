package ru.malkov.Cat;

public class MeowCountDecorator implements Meowable {
    private Meowable decoratedCat;
    private int meowCount = 0;

    public MeowCountDecorator(Meowable decoratedCat) {
        this.decoratedCat = decoratedCat;
    }

    @Override
    public void meow() {
        decoratedCat.meow();
        meowCount++;
    }

    public int getMeowCount() {
        return meowCount;
    }
}
