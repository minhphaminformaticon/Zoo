package com.informaticon.java.tutorial.zoo.miph.animals;

import com.informaticon.java.tutorial.zoo.miph.animals.template.PreyAnimal;

public class Zebra extends Animal implements PreyAnimal {
    public Zebra(String name, int age, int strength, int health, int defense, int speed) {
        super(name, age, strength, health, defense, speed);
        setIcon("✩\uD83E\uDD93✮");
        setStripedFur(getName() + " has striped black white fur.");
    }

    private String stripedFur;

    @Override
    public void makeSound() {
        System.out.println(getName() + " brays");
    }

    @Override
    public void action() {
        eatPlants();
    }

    @Override
    public void attributes() {
        System.out.println(getStripedFur());
    }

    @Override
    public void eatPlants() {
        System.out.println(getName() + " eats plants");
    }

    public String getStripedFur() {
        return stripedFur;
    }

    public void setStripedFur(String stripedFur) {
        this.stripedFur = stripedFur;
    }
}