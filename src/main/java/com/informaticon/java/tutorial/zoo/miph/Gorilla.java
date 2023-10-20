package com.informaticon.java.tutorial.zoo.miph;

public class Gorilla extends Animal implements PreyAnimal {
    public Gorilla(String name, int age, int strength, int health, int defense, int speed) {
        super(name, age, strength, health, defense, speed);
        setIcon("✩\uD83E\uDD8D✮");
        setAnimal("gorilla");
    }

    String bigArms = getName() + " has big enormous arms to climb trees.";

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
        System.out.println(bigArms);
    }

    @Override
    public void eatPlants() {
        System.out.println(getName() + " eats plants.");
    }
}