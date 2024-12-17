package ru.malkov;

import ru.malkov.Cat.Cat;
import ru.malkov.Cat.MeowCountDecorator;
import ru.malkov.Cat.Meowable;
import ru.malkov.Cat.MeowableCat;
import ru.malkov.CommonList.CommonList;
import ru.malkov.Fraction.Fraction;
import ru.malkov.Fraction.FractionFactory;
import ru.malkov.Fraction.IFraction;
import ru.malkov.GasStationAnalyzer.GasStationAnalyzer;
import ru.malkov.GasStationAnalyzer.IGasStationAnalyzer;
import ru.malkov.LetterCounter.ILetterCounter;
import ru.malkov.LetterCounter.LetterCounter;
import ru.malkov.PersonReader.IPersonReader;
import ru.malkov.PersonReader.PersonReader;
import ru.malkov.PointPolyline.IPointPolyline;
import ru.malkov.PointPolyline.Point;
import ru.malkov.PointPolyline.PointPolyline;
import ru.malkov.PointPolyline.Polyline;
import ru.malkov.QueueBuilder.QueueBuilder;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        main.testCommonList();
        main.testCatMeow();
        main.testGasStationAnalyzer();
        main.testFraction();
        main.testLetterCounter();
        main.testQueueBuilder();
        main.testPointPolylineStream();
        main.testPersonReader();
    }

    public void testCommonList() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 5, 6);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8, 9);

        CommonList commonList = new CommonList();
        List<Integer> commonElements = commonList.getCommonElements(list1, list2);

        System.out.println("Лист 1: " + list1);
        System.out.println("Лист 2: " + list2);
        System.out.println("Список L: " + commonElements);
    }

    public void testCatMeow() {

        Meowable cat1 = new Cat("Барсик");
        Meowable cat2 = new Cat("Мурзик");
        Meowable cat3 = new Cat("Пушик");

        Meowable decoratedCat1 = new MeowCountDecorator(cat1);
        Meowable decoratedCat2 = new MeowCountDecorator(cat2);
        Meowable decoratedCat3 = new MeowCountDecorator(cat3);

        MeowableCat catMeowAdapter  = new MeowableCat();
        catMeowAdapter.makeAllMeow(decoratedCat1, decoratedCat2, decoratedCat3);

        MeowCountDecorator countDecorator1 = (MeowCountDecorator) decoratedCat1;
        MeowCountDecorator countDecorator2 = (MeowCountDecorator) decoratedCat2;
        MeowCountDecorator countDecorator3 = (MeowCountDecorator) decoratedCat3;

        System.out.println("Барсик мяукал " + countDecorator1.getMeowCount() + " раз");
        System.out.println("Мурзик мяукал " + countDecorator2.getMeowCount() + " раз");
        System.out.println("Пушик мяукал " + countDecorator3.getMeowCount() + " раз");

    }

    public void testGasStationAnalyzer() {
        try {
            GasStationAnalyzer analyzer = new GasStationAnalyzer();
            analyzer.loadFromFile("/home/vanish/IdeaProjects/lab5/src/main/java/ru/malkov/GasStation.txt");
            int[] counts = analyzer.getCheapestCounts();
            System.out.println("Самый дешёвый бензин: 92=" + counts[0] + ", 95=" + counts[1] + ", 98=" + counts[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testLetterCounter() {
        String filePath = "/home/vanish/IdeaProjects/lab5/src/main/java/ru/malkov/Letter.txt";

        ILetterCounter letterCounter = new LetterCounter();
        try {
            int uniqueLetterCount = letterCounter.countUniqueLetters(filePath);
            System.out.println("Количество уникальных букв в тексте: " + uniqueLetterCount);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public void testFraction() {
        IFraction fraction = FractionFactory.createFraction(4, 5);
        IFraction fraction2 = FractionFactory.createFraction(1, 3);
        System.out.println("Дробь 1: " + fraction);
        System.out.println("Дробь 2: " + fraction2);
        System.out.println("Вещественное значение дроби 1: " + fraction.toDouble());

        System.out.println("Дробь 1 равна дроби 2: " + fraction.equals(fraction2));
        fraction.setNumerator(1);
        System.out.println("Изменённая дробь 1: " + fraction);
        System.out.println("Вещественное значение измененной дроби 1: " + fraction.toDouble());

        fraction.setDenominator(3);
        System.out.println("Изменённая дробь 1: " + fraction);
        System.out.println("Вещественное значение измененной дроби 1: " + fraction.toDouble());

        System.out.println("Дробь 1 равна дроби 2: " + fraction.equals(fraction2));
    }

    public void testQueueBuilder() {
        List<Integer> list = Arrays.asList(1, 2, 3);

        QueueBuilder queueBuilder = new QueueBuilder();
        Deque<Integer> queue = queueBuilder.buildQueue(list);

        System.out.println("Очередь: " + queue);
    }

    public void testPointPolylineStream() {
        List<Point> points = Arrays.asList(
                new Point(1, 2),
                new Point(2, 3),
                new Point(1, 2),
                new Point(3, -4),
                new Point(4, 5)
        );

        IPointPolyline pointPolylineStream = new PointPolyline();
        List<Point> uniquePoints = pointPolylineStream.processPoints(points);

        Polyline polyline = new Polyline(uniquePoints);
        System.out.println("Ломаная линия: " + polyline);
    }

    public void testPersonReader() {
        String filePath = "/home/vanish/IdeaProjects/lab5/src/main/java/ru/malkov/Person.txt";

        IPersonReader personReader = new PersonReader();
        Map<Integer, List<String>> groupedByName = personReader.readAndProcessPersons(filePath);

        System.out.println("Группировка по номерам: " + groupedByName);
    }
}
