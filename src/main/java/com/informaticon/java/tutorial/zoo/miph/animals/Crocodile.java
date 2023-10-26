package com.informaticon.java.tutorial.zoo.miph.animals;

import com.informaticon.java.tutorial.zoo.miph.animals.template.Predator;

public class Crocodile extends Animal implements Predator {
    public Crocodile(String name, int age, int strength, int health, int defense, int speed) {
        super(name, age, strength, health, defense, speed);
        setIcon(getIcon());
        setClaws("With its sharp claws on all fours, it stalks its prey underwater.");
        setScale(getName() + " uses its scales to protect itself.");
    }

    private String claws;

    private String scale;


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
        System.out.println(getClaws());
        System.out.println(getScale());
    }

    @Override
    public void hunt() {
        System.out.println(getName() + " hunts its prey.");
    }

    @Override
    public void eatMeat() {
        System.out.println(getName() + "eats meat");
    }

    public String getClaws() {
        return claws;
    }

    public void setClaws(String claws) {
        this.claws = claws;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }
}