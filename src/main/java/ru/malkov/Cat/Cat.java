package ru.malkov.Cat;

public class Cat implements  Meowable{
    private String name;
    private int meowCount;

    public Cat(String name) {
        this.name = name;
        this.meowCount = 0;
    }

    public void meow() {
        System.out.println(name + ": мяу!");
        meowCount++;
    }

    public int getMeowCount() {
        return meowCount;
    }

    @Override
    public String toString() {
        return "кот: " + name;
    }
}
