package ru.malkov.Fraction;

public class Fraction  implements IFraction {
    private int numerator;
    private int denominator;
    private Double cachedValue;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
        this.cachedValue = null;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        this.cachedValue = null;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        if (denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -denominator;
        } else {
            this.denominator = denominator;
        }
        this.cachedValue = null;
    }

    public double getRealValue() {
        if (cachedValue == null) {
            cachedValue = (double) numerator / denominator;
        }
        return cachedValue;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fraction fraction = (Fraction) obj;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return 31 * numerator + denominator;
    }
}
