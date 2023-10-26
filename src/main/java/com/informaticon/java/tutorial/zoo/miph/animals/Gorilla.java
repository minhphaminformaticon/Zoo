package com.informaticon.java.tutorial.zoo.miph.animals;

import com.informaticon.java.tutorial.zoo.miph.animals.template.PreyAnimal;

public class Gorilla extends Animal implements PreyAnimal {
    public Gorilla(String name, int age, int strength, int health, int defense, int speed) {
        super(name, age, strength, health, defense, speed);
        setIcon("✩\uD83E\uDD8D✮");
        setBigArms(getName() + " has big enormous arms to climb trees.");
    }

    private String bigArms;

    @Override
    public void makeSound() {
        System.out.println(getName() + " beats its chest!");
    }

    @Override
    public void action() {
        eatPlants();
    }

    @Override
    public void attributes() {
        System.out.println(getBigArms());
    }

    @Override
    public void eatPlants() {
        System.out.println(getName() + " eats plants.");
    }

    public String getBigArms() {
        return bigArms;
    }

    public void setBigArms(String bigArms) {
        this.bigArms = bigArms;
    }
}