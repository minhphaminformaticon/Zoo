package com.informaticon.java.tutorial.zoo.miph;

public class Zebra extends Animal implements PreyAnimal {
    public Zebra(String name, int age, int strength, int health, int defense, int speed) {
        super(name, age, strength, health, defense, speed);
        setIcon("✩\uD83E\uDD93✮");
        setAnimal("zebra");
    }

    String stripedFur = getName() + " has striped black white fur.";


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
        System.out.println(stripedFur);
    }

    @Override
    public void eatPlants() {
        System.out.println(getName() + " eats plants");
    }
}
