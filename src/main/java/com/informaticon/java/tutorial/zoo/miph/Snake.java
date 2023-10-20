package com.informaticon.java.tutorial.zoo.miph;

public class Snake extends Animal implements Predator {
    public Snake(String name, int age, int strength, int health, int defense, int speed) {
        super(name, age, strength, health, defense, speed);
        setIcon("✩\uD83D\uDC0D✮");
        setAnimal("snake");
    }

    String scale = getName() + " uses the scale to shed its skin";


    @Override
    public void makeSound() {
        System.out.println(getName() + " hisses!");
    }

    @Override
    public void action() {
        hunt();
        eatMeat();
    }

    @Override
    public void attributes() {
        System.out.println(scale);

    }

    @Override
    public void hunt() {
        System.out.println(getName() + " slithers and hunts for prey.");
    }

    @Override
    public void eatMeat() {
        System.out.println(getName() + " eats meat.");
    }

}