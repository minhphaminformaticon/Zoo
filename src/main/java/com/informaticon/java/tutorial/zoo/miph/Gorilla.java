package com.informaticon.java.tutorial.zoo.miph;

public class Gorilla extends Animal implements PreyAnimal {
    public Gorilla(String name, int age, int strength, int health, int defense) {
        super(name, age, strength, health, defense);
        setIcon("✩\uD83E\uDD8D✮");
    }

    String animal = "gorilla";

    String bigArms = name + " has big enormous arms to climb trees.";

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


    @Override
    public String getAnimal() {
        return animal;
    }
}