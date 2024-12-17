package ru.malkov.Fraction;

public class CachedFractionDecorator implements IFraction {
    private final IFraction fraction;
    private Double cachedValue = null;

    public CachedFractionDecorator(IFraction fraction) {
        this.fraction = fraction;
    }

    @Override
    public double toDouble() {
        if (cachedValue == null) {
            cachedValue = fraction.toDouble();
        }
        return cachedValue;
    }

    @Override
    public void setNumerator(int numerator) {
        fraction.setNumerator(numerator);
        invalidateCache();
    }

    @Override
    public void setDenominator(int denominator) {
        fraction.setDenominator(denominator);
        invalidateCache();
    }

    private void invalidateCache() {
        cachedValue = null;
    }

    @Override
    public String toString() {
        return fraction.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CachedFractionDecorator)) {
            return false;
        }

        CachedFractionDecorator other = (CachedFractionDecorator) obj;
        return this.fraction.equals(other.fraction);
    }

}
