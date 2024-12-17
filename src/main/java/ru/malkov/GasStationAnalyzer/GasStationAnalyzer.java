package ru.malkov.GasStationAnalyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    public void loadFromFile(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 4) {
                    String company = parts[0].trim();
                    String street = parts[1].trim();
                    int grade = Integer.parseInt(parts[2].trim());
                    int price = Integer.parseInt(parts[3].trim());
                    addGasStation(company, street, grade, price);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "GasStationAnalyzer{" +
                "minPrices=" + minPrices +
                ", counts=" + counts +
                '}';
    }
}
