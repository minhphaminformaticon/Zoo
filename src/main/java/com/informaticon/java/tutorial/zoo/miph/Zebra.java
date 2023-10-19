package com.informaticon.java.tutorial.zoo.miph;

public class Zebra extends Animal implements PreyAnimal {
    public Zebra(String name, int age, int strength, int health, int defense) {
        super(name, age, strength, health, defense);
        setIcon("✩\uD83E\uDD93✮");
    }

    String stripedFur = getName() + " has striped black white fur.";

    String animal = "zebra";


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


    @Override
    public String getAnimal() {
        return animal;
    }
}
