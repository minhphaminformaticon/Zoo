package com.informaticon.java.tutorial.zoo.miph;

public class Elephant extends Animal implements PreyAnimal {
    public Elephant(String name, int age, int strength, int health, int defense) {
        super(name, age, strength, health, defense);
        setIcon("✩\uD83D\uDC18✮");
    }

    String tusk = "the mighty " + name + " has big tusks.";
    String trunk = "the elephant's trunk is used for eating, gripping or drinking.";

    String animal = "elephant";


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
        System.out.println(tusk);
        System.out.println(trunk);
    }

    @Override
    public String getAnimal() {
        return animal;
    }
}