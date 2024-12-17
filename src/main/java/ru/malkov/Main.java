package ru.malkov;

import ru.malkov.Cat.Cat;
import ru.malkov.Cat.Meowable;
import ru.malkov.Cat.MeowableCat;
import ru.malkov.CommonList.CommonList;
import ru.malkov.Fraction.Fraction;
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
        Meowable cat1 = new Cat("Мурзик");
        Meowable cat2 = new Cat("Барсик");
        Meowable cat3 = new Cat("Пушок");

        MeowableCat.makeAllMeow(cat1, cat2, cat3);

        System.out.println("Количество мяуканий Мурзика: " + cat1.getMeowCount());
        System.out.println("Количество мяуканий Барсика: " + cat2.getMeowCount());
        System.out.println("Количество мяуканий Пушка: " + cat3.getMeowCount());
    }

    public void testGasStationAnalyzer() {
        List<String> inputData = Arrays.asList(
                "Синойл Цветочная 95 59",
                "Роснефть Ленина 92 60",
                "Лукойл Пушкина 95 58",
                "Газпром Проспект 98 62",
                "Синойл Цветочная 92 57",
                "Роснефть Ленина 98 61",
                "Лукойл Пушкина 92 57",
                "Газпром Проспект 95 59"
        );

        IGasStationAnalyzer analyzer = new GasStationAnalyzer();

        for (String input : inputData) {
            String[] parts = input.split(" ");
            String company = parts[0];
            String street = parts[1];
            int grade = Integer.parseInt(parts[2]);
            int price = Integer.parseInt(parts[3]);

            analyzer.addGasStation(company, street, grade, price);
        }

        int[] result = analyzer.getCheapestCounts();
        System.out.println("Количество АЗС, продающих дешевле всего 92-й бензин: " + result[0]);
        System.out.println("Количество АЗС, продающих дешевле всего 95-й бензин: " + result[1]);
        System.out.println("Количество АЗС, продающих дешевле всего 98-й бензин: " + result[2]);
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
        IFraction fraction1 = new Fraction(3, 4);
        IFraction fraction2 = new Fraction(-3, 4);
        IFraction fraction3 = new Fraction(3, -4);
        IFraction fraction4 = new Fraction(3, 4);

        System.out.println("Дробь 1: " + fraction1);
        System.out.println("Дробь 2: " + fraction2);
        System.out.println("Дробь 3: " + fraction3);
        System.out.println("Дробь 4: " + fraction4);

        System.out.println("Вещественное значение дроби 1: " + fraction1.getRealValue());
        System.out.println("Вещественное значение дроби 2: " + fraction2.getRealValue());
        System.out.println("Вещественное значение дроби 3: " + fraction3.getRealValue());
        System.out.println("Вещественное значение дроби 4: " + fraction4.getRealValue());

        System.out.println("Дробь 1 равна дроби 2: " + fraction1.equals(fraction2));
        System.out.println("Дробь 1 равна дроби 3: " + fraction1.equals(fraction3));
        System.out.println("Дробь 1 равна дроби 4: " + fraction1.equals(fraction4));

        fraction1.setNumerator(6);
        fraction1.setDenominator(8);
        System.out.println("Обновленная дробь 1: " + fraction1);
        System.out.println("Вещественное значение обновленной дроби 1: " + fraction1.getRealValue());
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
