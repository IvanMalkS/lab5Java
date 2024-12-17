package ru.malkov.Cat;

public class Cat implements  Meowable{
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println(name + ": мяу!");
    }


    @Override
    public String toString() {
        return "кот: " + name;
    }
}
