package com.company;
import java.util.ArrayList;

public class Necklace {
    private final ArrayList<Precious> prStones;
    private final ArrayList<SemiPrecious> semiStones;
    private double totalCost;
    private double totalWeight;
    public Necklace() {
        prStones = new ArrayList<>();
        semiStones = new ArrayList<>();
        totalCost = 0;
        totalWeight = 0;
    }
    public double getTotalCost() {
        return totalCost;
    }
    public double getTotalWeight() {
        return totalWeight;
    }
    private void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }
    private void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    public void addPrecious(Precious st) {
        prStones.add(st);
    }
    public void addSemiPrecious(SemiPrecious st) {
        semiStones.add(st);
    }
    public void GetStones() {
        System.out.printf("%-15s%-15s%s%n", "Name", "Weight", "Cost per carat");
        for (Precious prStone : prStones) {
            System.out.printf("%-15s%f%15f%n", prStone.getName(), prStone.getWeight(), prStone.getCostPerCarat());
        }
        for (SemiPrecious semiStone : semiStones)
            System.out.printf("%-15s%f%15f%n", semiStone.getName(), semiStone.getWeight(), semiStone.getCostPerCarat());
    }
    public void getCost() {
        double tCost = 0;
        double tWeight = 0;
        for (Precious prStone : prStones) {
            tCost += prStone.getCost();
            tWeight += prStone.getWeight();
        }
        for (SemiPrecious semiStone : semiStones) {
            tCost += semiStone.getCost();
            tWeight += semiStone.getWeight();
        }
        setTotalCost(tCost * 1.3); //сперва умножает на вес камня и добавляет +30% за работу мастера лол
        setTotalWeight(tWeight + 7); //Саама цепь кайнда 7 граммов весит, по дефолту взяли
    }
}
