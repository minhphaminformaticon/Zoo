package com.informaticon.java.tutorial.zoo.miph;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String animalType;
    private List<Animal> animalsInCage;

    public Cage(String animalType) {
        this.animalType = animalType;
        this.animalsInCage = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animalsInCage.add(animal);
    }

    public int getCageSpace() {
        return animalsInCage.size();
    }
    public double getCageSize() {
        double baseCageSize = 6.1 * 4.6;
        double additionalSpacePerAnimal = baseCageSize * 0.5;

        double cageSize = baseCageSize + (additionalSpacePerAnimal * animalsInCage.size());

        return (double) Math.round(cageSize * 100) /100;
    }
    public void displayCageInfo() {
        System.out.println();
        System.out.println("zoo.Cage for " + animalType + ":");
        System.out.println("Number of zoo.animals: " + getCageSpace());
        System.out.println("Size:" + getCageSize() + " m2");
    }

    public Object getAnimalType() {
        return animalType;
    }
}
