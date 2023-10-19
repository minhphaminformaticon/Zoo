package com.informaticon.java.tutorial.zoo.miph;

public class Lion extends Animal implements Predator {
    String mane = name + " has majestic golden mane";

    public Lion(String name, int age, int strength, int health, int defense) {
        super(name, age, strength, health, defense);
        setIcon("✩🦁✮");
    }

    String animal = "lion";

    int strength = 20;

    int defense = 10;
    String icon = "✩\uD83E\uDD81✮";

    public Lion() {
        super();
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getDefense() {
        return defense;
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

    @Override
    public String getAnimal() {
        return animal;
    }
}
