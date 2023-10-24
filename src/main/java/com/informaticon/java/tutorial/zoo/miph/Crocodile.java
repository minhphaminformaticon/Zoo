package com.informaticon.java.tutorial.zoo.miph;

public class Crocodile extends Animal implements Predator {
    public Crocodile(String name, int age, int strength, int health, int defense, int speed) {
        super(name, age, strength, health, defense, speed);
        setIcon(getIcon());
        setAnimal("crocodile");
    }

    String claws = "With its sharp claws on all fours, it stalks its prey underwater.";

    String scale = getName() + " uses its scales to protect itself.";


    @Override
    public void makeSound() {
        System.out.println(getName() + " has a deep growl.");
    }

    @Override
    public void action() {
        System.out.println(getName() + ", the crocodile, a stealthy reptile with massive jaws.");
    }

    @Override
    public void attributes() {
        System.out.println(scale);
        System.out.println(claws);
    }

    @Override
    public void hunt() {
        System.out.println(getName() + " hunts its prey.");
    }

    @Override
    public void eatMeat() {
        System.out.println(getName() + "eats meat");
    }
}