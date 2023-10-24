package com.informaticon.java.tutorial.zoo.miph;

public class Shark extends Animal implements Predator, SeaAnimal {

    public Shark(String name, int age, int strength, int health, int defense, int speed) {
        super(name, age, strength, health, defense, speed);
        setIcon("✩\uD83E\uDD88✮");
        setAnimal("shark");
    }

    String fin = "the big scary " + getName() + " uses its fins to swim in the deep.";
    String kingOfTheSea = "The shark is the king of the deep.";

    @Override
    public void makeSound() {
        System.out.println(getName() + " makes underwater noises.");
    }


    @Override
    public void action() {
        hunt();
        eatFish();
        eatMeat();
        swim();
    }

    @Override
    public void attributes() {
        System.out.println(fin);
        System.out.println(kingOfTheSea);
    }

    @Override
    public void hunt() {
        System.out.println(getName() + " hunts other fish.");
    }

    @Override
    public void eatMeat() {
        System.out.println(getName() + " eats meat");
    }

    @Override
    public void swim() {
        System.out.println(getName() + " swims gracefully.");
    }

    @Override
    public void eatFish() {
        System.out.println(getName() + " eats fish.");
    }
}