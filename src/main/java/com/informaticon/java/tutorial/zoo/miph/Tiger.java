package com.informaticon.java.tutorial.zoo.miph;

public class Tiger extends Animal implements Predator {
    public Tiger(String name, int age, int strength, int health, int defense) {
        super(name, age, strength, health, defense);
        setIcon("✩\uD83D\uDC2F✮");
    }

    String animal = "tiger";
    String claws = getName() + " has huge claws to deal huge damage to its prey.";
    
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
        System.out.println(claws);
    }

    @Override
    public void hunt() {
        System.out.println(getName() + " hunts.");
    }

    @Override
    public void eatMeat() {
        System.out.println(getName() + " eats meat.");
    }

    @Override
    public String getAnimal() {
        return animal;
    }


}
