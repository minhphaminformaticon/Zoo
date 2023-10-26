package com.informaticon.java.tutorial.zoo.miph.animals;

import com.informaticon.java.tutorial.zoo.miph.animals.template.Predator;

public class Lion extends Animal implements Predator {
    private String mane;

    public Lion(String name, int age, int strength, int health, int defense, int speed) {
        super(name, age, strength, health, defense, speed);
        setIcon("✩🦁✮");
        setMane(getName() + " has majestic golden mane");
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

    public String getMane() {
        return mane;
    }

    public void setMane(String mane) {
        this.mane = mane;
    }

    @Override
    public void attributes() {
        System.out.println(getMane());
    }
}