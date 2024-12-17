package ru.malkov.Fraction;
public class FractionFactory {
    public static IFraction createFraction(int numerator, int denominator) {
        return new CachedFractionDecorator(new Fraction(numerator, denominator));
    }
    }
