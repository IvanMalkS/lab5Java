package ru.malkov.GasStationAnalyzer;

public interface IGasStationAnalyzer {
    void addGasStation(String company, String street, int grade, int price);
    int[] getCheapestCounts();
}
