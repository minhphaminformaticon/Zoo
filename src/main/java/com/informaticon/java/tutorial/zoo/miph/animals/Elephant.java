package com.informaticon.java.tutorial.zoo.miph.animals;

import com.informaticon.java.tutorial.zoo.miph.animals.template.PreyAnimal;

public class Elephant extends Animal implements PreyAnimal {
    public Elephant(String name, int age, int strength, int health, int defense, int speed) {
        super(name, age, strength, health, defense, speed);
        setIcon("✩\uD83D\uDC18✮");
        setTusk("the mighty " + getName() + " has big tusks.");
        setTrunk("the elephant's trunk is used for eating, gripping or drinking.");
    }

    private String tusk;
    private String trunk;


    @Override
    public void makeSound() {
        System.out.println(getName() + " trumpets!");
    }

    @Override
    public void eatPlants() {
        System.out.println(getName() + " eats plants.");
    }

    @Override
    public void action() {
        eatPlants();
    }

    @Override
    public void attributes() {
        System.out.println(getTrunk());
        System.out.println(getTusk());
    }

    public String getTusk() {
        return tusk;
    }

    public void setTusk(String tusk) {
        this.tusk = tusk;
    }

    public String getTrunk() {
        return trunk;
    }

    public void setTrunk(String trunk) {
        this.trunk = trunk;
    }
}