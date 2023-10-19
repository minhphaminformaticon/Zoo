package com.informaticon.java.tutorial.zoo.miph;

public class Panda extends Animal implements PreyAnimal {

    public Panda(String name, int age, int strength, int health, int defense) {
        super(name, age, strength, health, defense);
        setIcon("✩\uD83D\uDC3C✮");
    }

    String cuteEyes = getName() + " has super cute eyes.";

    String animal = "panda";

    String icon = "✩\uD83D\uDC3C✮";

    @Override
    public void makeSound() {
        System.out.println(getName() + " growls!");
    }

    @Override
    public void action() {
        eatPlants();
    }

    @Override
    public void attributes() {
        System.out.println(cuteEyes);
    }

    @Override
    public void eatPlants() {
        System.out.println(getName() + " eats bamboos everyday.");
    }


    @Override
    public String getAnimal() {
        return animal;
    }
}
