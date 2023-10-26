package com.informaticon.java.tutorial.zoo.miph.animals;

import com.informaticon.java.tutorial.zoo.miph.animals.template.PreyAnimal;
import com.informaticon.java.tutorial.zoo.miph.animals.template.SeaAnimal;

public class Penguin extends Animal implements PreyAnimal, SeaAnimal {
    public Penguin(String name, int age, int strength, int health, int defense, int speed) {
        super(name, age, strength, health, defense, speed);
        setIcon("✩\uD83D\uDC27✮");
        setWings(getName() + " uses the wings to swim underwater.");
        setBeak(getName() + " uses the beak to consume fishes.");
    }

    private String wings;
    private String beak;

    @Override
    public void makeSound() {
        System.out.println(getName() + " makes chirping sounds.");
    }

    @Override
    public void action() {
        swim();
        eatFish();
    }

    @Override
    public void attributes() {
        System.out.println(getBeak());
        System.out.println(getWings());
    }

    @Override
    public void swim() {
        System.out.println(getName() + " swims in the cold waters.");
    }

    @Override
    public void eatFish() {
        System.out.println(getName() + " eats fish.");
    }

    @Override
    public void eatPlants() {
        System.out.println();
    }

    public String getWings() {
        return wings;
    }

    public void setWings(String wings) {
        this.wings = wings;
    }

    public String getBeak() {
        return beak;
    }

    public void setBeak(String beak) {
        this.beak = beak;
    }
}