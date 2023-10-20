package com.informaticon.java.tutorial.zoo.miph;

public class Giraffe extends Animal implements PreyAnimal {

    public Giraffe(String name, int age, int strength, int health, int defense, int speed) {
        super(name, age, strength, health, defense, speed);
        setIcon("✩\uD83E\uDD92✮");
        setAnimal("giraffe");
    }


    String longNeck = getName() + " has a long neck";

    @Override
    public void makeSound() {
        System.out.println("it doesnt make any sounds.");
    }

    @Override
    public void action() {
        eatPlants();
    }

    @Override
    public void attributes() {
        System.out.println(longNeck);
    }

    @Override
    public void eatPlants() {
        System.out.println(getName() + " eats plants-");
    }


}
