package com.informaticon.java.tutorial.zoo.miph.animals;

import com.informaticon.java.tutorial.zoo.miph.animals.template.Predator;

public class Tiger extends Animal implements Predator {
    public Tiger(String name, int age, int strength, int health, int defense, int speed) {
        super(name, age, strength, health, defense, speed);
        setIcon("✩\uD83D\uDC2F✮");
        setClaws(getName() + " uses the scale to shed its skin");
    }

    private String claws = getName() + " has huge claws to deal huge damage to its prey.";

    @Override
    public void makeSound() {
        System.out.println(getName() + " roars!");
    }

    @Override
    public void action() {
        hunt();
        eatMeat();
    }

    @Override
    public void attributes() {
        System.out.println(getClaws());
    }

    @Override
    public void hunt() {
        System.out.println(getName() + " hunts.");
    }

    @Override
    public void eatMeat() {
        System.out.println(getName() + " eats meat.");
    }

    public String getClaws() {
        return claws;
    }

    public void setClaws(String claws) {
        this.claws = claws;
    }
}