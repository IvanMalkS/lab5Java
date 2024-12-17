package ru.malkov.GasStationAnalyzer;

import java.util.HashMap;
import java.util.Map;

public class GasStationAnalyzer implements IGasStationAnalyzer {
    private Map<Integer, Integer> minPrices;
    private Map<Integer, Integer> counts;

    public GasStationAnalyzer() {
        minPrices = new HashMap<>();
        counts = new HashMap<>();
        minPrices.put(92, Integer.MAX_VALUE);
        minPrices.put(95, Integer.MAX_VALUE);
        minPrices.put(98, Integer.MAX_VALUE);
        counts.put(92, 0);
        counts.put(95, 0);
        counts.put(98, 0);
    }

    @Override
    public void addGasStation(String company, String street, int grade, int price) {
        if (price < minPrices.get(grade)) {
            minPrices.put(grade, price);
            counts.put(grade, 1);
        } else if (price == minPrices.get(grade)) {
            counts.put(grade, counts.get(grade) + 1);
        }
    }

    @Override
    public int[] getCheapestCounts() {
        return new int[]{counts.get(92), counts.get(95), counts.get(98)};
    }

    @Override
    public String toString() {
        return "GasStationAnalyzer{" +
                "minPrices=" + minPrices +
                ", counts=" + counts +
                '}';
    }
}
