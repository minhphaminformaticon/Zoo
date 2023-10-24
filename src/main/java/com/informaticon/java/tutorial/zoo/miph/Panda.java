package com.informaticon.java.tutorial.zoo.miph;

public class Panda extends Animal implements PreyAnimal {

    public Panda(String name, int age, int strength, int health, int defense, int speed) {
        super(name, age, strength, health, defense, speed);
        setIcon("✩\uD83D\uDC3C✮");
        setAnimal("panda");
    }

    String cuteEyes = getName() + " has super cute eyes.";


    @Override
    public void makeSound() {
        System.out.println(getName() + " growls!");
    }

    @Override
    public void action() {
        eatPlants();
    }

    @Override
    public void attributes() {
        System.out.println(cuteEyes);
    }

    @Override
    public void eatPlants() {
        System.out.println(getName() + " eats bamboos everyday.");
    }
}