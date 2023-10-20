package com.informaticon.java.tutorial.zoo.miph;

public class Lion extends Animal implements Predator {
    String mane = getName() + " has majestic golden mane";

    public Lion(String name, int age, int strength, int health, int defense, int speed) {
        super(name, age, strength, health, defense, speed);
        setIcon("✩🦁✮");
        setAnimal("lion");
    }


    @Override
    public void makeSound() {
        System.out.println(getName() + " roars!");
    }

    @Override
    public void hunt() {
        System.out.println(getName() + " hunts other zoo.animals.");
    }

    @Override
    public void eatMeat() {
        System.out.println(getName() + " eats other zoo.animals.");
    }


    @Override
    public void action() {
        hunt();
        eatMeat();
    }

    @Override
    public void attributes() {
        System.out.println(mane);
    }
}


